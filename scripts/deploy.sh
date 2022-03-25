#!/bin/bash

REPOSITORY=/home/ec2-user/app
PROJECT_NAME=yourlist
JAR_FILE=$(ls /home/ec2-user/app/build/build/libs | grep -v plain)

echo "> Build 파일 복사"
#절대 경로 사용
/usr/bin/cp -f $REPOSITORY/build/build/libs/$JAR_FILE $REPOSITORY/jar

echo "> 현재 구동 중인 애플리케이션 pid 확인"

CURRENT_PID=$(pgrep -lf $PROJECT_NAME | grep java | awk '{print $1}')

echo "현재 구동 중인 애플리케이션 pid: $CURRENT_PID"

if [ -z "$CURRENT_PID" ]; then
  echo "> 현재 구동 중인 애플리케이션이 없으므로 종료하지 않습니다."
else
  echo "> kill -15 $CURRENT_PID"
  kill -15 $CURRENT_PID
  sleep 5
fi

echo "> 새 애플리케이션 배포"

JAR_NAME=$(ls -tr $REPOSITORY/jar/*.jar | tail -n 1)
Date=$(date "+%Y-%m-%d")
echo "> JAR name: JAR_NAME"
echo "> $JAR_NAME에 실행 권한 추가"
chmod +x $JAR_NAME

echo ">$JAR_NAME 실행"

#절대 경로 사용
#2>&1 -> .out파일에 stderr(에러 메시지)도 저장되도록!
nohup /opt/jdk-17/bin/java -jar $JAR_NAME > $REPOSITORY/monit/$Date.out 2>&1 &