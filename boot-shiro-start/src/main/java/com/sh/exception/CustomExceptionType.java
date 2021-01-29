package com.sh.exception;

public enum CustomExceptionType {

  USER_INPUT_ERROR(400,"您输入的数据格式错误或您没有权限访问资源！"),
  SYSTEM_ERROR (500,"系统出现异常，请您稍后再试或联系管理员！"),
  USER_NOLOGIN(300,"未登录12"),
  USERNAME_NOTFOUND(301,"无效的用户"),
  USERPASSWORD_NOTFOUND(302,"无效的密码"),
  LOGIN_SUCCESS(200,"登录成功"),
  UNAUTHORIZED(402,"无权访问"),
  UNAUTHORIZEDEXCEPTION(403,"当前Subject没有此请求所需权限"),
  UNAUTHENTICATEDEXCEPTION(405,"当前Subject是匿名Subject，请先登录"),
  BINDEXCEPTION(407,"校验失败"),
  METHODARGUMENTNOTVALIDEXCEPTION(408,"校验失败"),
  NOHANDLERFOUNDEXCEPTION(404,"校验失败"),
  EXCEPTION(410,"校验失败"),
  CUSTOMEXCEPTION(410,"校验失败");
  private String description;//异常类型中文描述
  private int code; //code

  CustomExceptionType(int code, String description) {
    this.code = code;
    this.description = description;
  }

  public String getDescription() {
    return description;
  }

  public int getCode() {
    return code;
  }

}
