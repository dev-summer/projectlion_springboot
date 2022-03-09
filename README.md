# projectlion_springboot
### 3차 미션 (Basic)

## GET /board/1
> 정상 작동 확인

<img width="861" alt="Screenshot 2022-03-09 at 14 23 55" src="https://user-images.githubusercontent.com/98260324/157378377-27dcda7c-de40-439e-8ce6-d0f20d9dbd52.png">

## GET /board/1/post/1
> password를 Long타입으로 주고 요청을 보냈는데 패스워드에 대한 요청이 정상적으로 들어가지 않음.  
> SQL에서 조회해도 똑같이 password가 null로 나온다. (해결 필요)  
> entity가 아닌 title list를 불러오면 좋을 것 같은데 어떻게 할 수 있을지 찾아보자 (다른사람 코드도 참고해보기)
<img width="949" alt="Screenshot 2022-03-09 at 14 47 18" src="https://user-images.githubusercontent.com/98260324/157380415-7b033ebf-7111-4857-af1b-329d24041e69.png">

## GET /user/1
> post와 동일하게 user도 password가 정상적으로 생성되지 않는 문제가 있음. (마찬가지로 password를 Long으로 설계함)
<img width="947" alt="Screenshot 2022-03-09 at 14 53 45" src="https://user-images.githubusercontent.com/98260324/157381040-b2bd1789-1487-4a78-953f-5ff58f6da015.png">
