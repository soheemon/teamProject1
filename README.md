# Kogile 

kosta project git repo..


## Ignore 재설정

기존 올라가면 안될 파일들이 올라가 있어 개인 설정파일과 충돌이나 제대로 실행이 안될 수도 있습니다. 
ignore 에 설정파일들을 제외하고 올리도록 설정하였으니 cache 를 날리고 다시 올리고 받거나 또는 기존의 파일을 날리고 새롭게 pull 을 받아주세요 


```
git rm -r –cached . # 기존 git 설정 cached 를 제거한다.
git add . # 재 설정된 ignore 를 적용하여 파일을 추가한다.
git commit -m "message"
git push origin <branch>
```

