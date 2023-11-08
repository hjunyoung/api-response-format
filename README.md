# API Response format 만들어 보기

Spring 과제를 하면서 팀원들과 과제 리뷰를 하던 중 팀원들마다 API response로 전달하는 데이터와 형식이 다 제각각인 것을 발견했다. 또 각 DTO마다 response의 형식이 달라진다는 문제점도 있었다. 지금은 한두명이서 과제를 하고 있지만, 어떤 형식으로 response를 보내줄 것인지는 형식을 정하는 것은 협업을 위해서 필수다.

많이 사용하는 API response 형식이 있다고 하지만, 공부도 하고 프로젝트에서 써볼 API response 형식을 만들어보기로 했다.

<br/>

## 설계를 할 때 고려한 사항

### 1. HTTP Status code는 반드시 보내준다.
    
몇몇 블로그에서는 HTTP Status code 없이 response를 보내는 것을 선호했는데 그 이유는 다음과 같다. 

   * HTTP 공식 사양에 41개의 너무 많은 statsu code가 존재해서 응답을 처리하는 경우의 수가 너무 많다.
   * HTTP는 브라우저를 대상으로 하는데 REST API의 대상은 브라우저만이 아니라 많은 클라이언트 프로그램을 포함한다.

위 말이 다 맞지만, HTTP Status code만으로도 요청/응답에 대한 충분히 많은 정보를 제공할 수 있다고 생각해서 포함시키기로 했다. 

<br/>

### 2. Response의 구조는 최대한 동일하게 설계한다.

성공했을 때와 실패/에러의 경우 response의 형식을 동일하게 유지해야 하려고 했는데 문제가 있었다.

```json
{
  "status": "string",
  "message": "string",
  "result": "object"
}
```

<br/>

위와 같은 방식으로 설계하면 성공/실패/에러 모든 경우에 동일한 형식으로 response를 전달할 수 있다. 하지만 성공했을 때와 실패/에러가 발생한 경우 result에 값이 들어가는게 뭔가 이상했다. 그래서 두 번쨰 방식을 만들어 봤다.

```json
// success
{
  "status": "string",
  "message": "string",
  "data": "object"
}

// error
{
  "status": "string",
  "message": "string"
}
```

<br/>

개인적으로는 두번째 방식이 더 마음에 드는데, 뭐가 더 좋은 방식인지는 아직 감이 잘 안 잡힌다.

더 많은 프로젝트를 해보고 실제로 사용해보면서 더 보완해나가자.

<br/>

## 보완해야 할 사항

- Response body로 전달되는 data에 front와 약속한 에러 코드를 보내주자.(5~6자리 숫자로)

- error와 fail을 명확히 구분해서 다시 구조를 잡자.

- BindingResult, FieldError, ObjectError 등 validation 관련 에러에 대해 공부하자.

<br/>
<br/>

## Reference

[JSend](https://github.com/omniti-labs/jsend)

[rest-api-response-format](https://github.com/cryptlex/rest-api-response-format)

[REST API Response Body 형식에 대한 경험적 구조](https://blog.storyg.co/rest-api-response-body-best-pratics)

[API Response 포맷에 관한 고찰](https://blog.lyunho.kim/api-response)

[스프링 API 공통 응답 포맷 개발하기](https://velog.io/@qotndus43/%EC%8A%A4%ED%94%84%EB%A7%81-API-%EA%B3%B5%ED%86%B5-%EC%9D%91%EB%8B%B5-%ED%8F%AC%EB%A7%B7-%EA%B0%9C%EB%B0%9C%ED%95%98%EA%B8%B0)

[REST API Response Format, 응답 객체는 어떤 형식이 좋을까?](https://wildeveloperetrain.tistory.com/240)