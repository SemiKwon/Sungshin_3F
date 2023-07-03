# *Sungshin_3F*
당신의 하루를 책임지는 공간, Sungshin_3F

코로나로 인해 학우들이 한정적인 활동을 할 수밖에 없는 배경에서 20, 21학번 학생들은 줌(zoom) 수업으로 학교 주변에서 체험할 수 있는 활동을 하지 못하는 상황이고, 이후 학번 학생들은 실내, 특히 집에서만 할 수 있는 활동을 찾는 상황에 놓이게 되었습니다. 

이에 주목하여 Sungshin_3F 앱은 학우들에게 코로나 상황에서 학교 주변 외부 활동이 가능한 공간과 외부 활동 시 필요한 요소들, 실내에서 할 수 있는 재미난 액티비티 들을 추천해주는 '추천 시스템'을 개발하고자 했습니다. **성신여대 학우들을 위한 Fashion, Food, Fun을 추천**한다는 점에서 착안하여 Sungshin_3F라고 이름붙였습니다.

## 📌 앱의 구성
|***|Fashin|Food|Fun|
|:---:|:---:|:---:|:---:|
|Inside(실내)|유저 패션 취향에 따른 브랜드|유튜브 요리 영상|웹툰|
|Outside(야외)|온도에 맞는 스타일|캠퍼스 맛집|연극|

## 📌 경쟁 앱과의 차별점
Sungshin_3F은 다른 앱과 차별점을 두기 위해 **캠퍼스 맛집과 연극**부분에 대한 설문조사를 진행하였습니다.

총 50명의 학우들에게 구글 설문지를 돌린 결과,

기존 맛집 앱(배달의 민족, 요기요 등)에서는 **광고성이 느껴지지 않는 진실된 후기**가 신뢰도를 낮추는 가장 큰 원인이 되었고, 이를 보완하기 위해 **상황별로 적절한 맛집 추천, 재방문의사** 기능이 필요하다는 의견을 받을 수 있었습니다.

이에 따라 앱에 **재방문의사와 상황별 맛집**을 추천 시스템에 반영할 수 있었습니다.

다음으로 연극 추천 부분에서는 연극 정보를 한 플랫폼에서 보기 어렵다는, 예매 방법에 대한 어려움이 가장 큰 비중을 차지했습니다. 따라서 연극 정보를 한눈에 볼 수 있도록 시스템을 구성했습니다.

## 📌 기능
**<Outside(외부)>**


**1. 연극**
   * 자세한 위치 정보 (링크 첨부) 및 최저가 플랫폼 제시
   * 연극 개인화 추천
   * 별점·댓글, 커뮤니티

**2. 캠퍼스 맛집(성신여대, 대학로)**
   * 식당 근처 캠퍼스(수정캠/운정캠) 및 대학로 위치에 따른 맛집 구분 
   * 재방문 의사

**3. 기상 상황에 맞는 스타일**
   * API를 통한 실시간 서울 날씨 확인
   * 체감 온도에 맞는 스타일 사진으로 제시

     
**<Inside(내부)>**

**1. 웹툰**
   * 장르별 네이버 웹툰과 신작 제시
   * 질문을 통한 취향 추천

**2. 요리 영상**
   * YouTube API를 통해 4가지 테마의 요리 영상을 제공받음.
   * 앱에서 바로 영상 재생 가능

**3. 패션**
   * 질문을 통해 이용자의 평소 패션 취향을 알아보고 브랜드와 스타일을 사진으로 제시

## 📌 코드 구성 요소
![Static Badge](https://img.shields.io/badge/Firebase-%23FF0000)
![Static Badge](https://img.shields.io/badge/API-%23FFA500)
![Static Badge](https://img.shields.io/badge/Crawling(Scrapping)-%23006400)
![Static Badge](https://img.shields.io/badge/Recommendation_Algorithm-%230000FF)
---


# *1. Firebase*

구글에서 개발에 필요한 백엔드에 해당하는 구성 요소(인증, 데이터베이스 연결, 푸시 알람, 스토리지, API 등)를 제공하는 모바일 애플리케이션 플랫폼

Outside-Fun 부분의 연극 데이터를 가져오는 부분에서 Firebase의 데이터베이스 기능을 활용

**1) 연극 추천**
① 연극 공공데이터 API의 JSON 문서를 활용하여 연극에 필요한 정보를 list로 바꾸어 데이터베이스를 구성하였습니다.
② 연극 데이터를 호출하기 위해 대용량의 데이터를 순회하며 보여주는 generator를 생성하고, 데이터베이스를 Firebase와 연결시켜주었습니다.
③ Firebase와 연결된 연극 데이터베이스를 가져오기 위해 연극 Object와 문서의 아이디를 get() 함수로 받아오는 방식을 선택했습니다.
④ 중간 객체 역할을 하는 Adapter를 활용하여 데이터를 리싸이클러뷰와 뷰홀더로 불러왔습니다.
⑤ 데이터를 리스트로 불러오되, 새로 추가되는 데이터들은 리스트에 삽입하기 위해 map()함수를 활용하여 새로운 배열을 만드는 방법으로 코드를 구성했습니다.

