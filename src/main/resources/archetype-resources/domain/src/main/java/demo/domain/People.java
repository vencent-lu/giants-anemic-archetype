#set( $symbol_pound = '#' )
#set( $symbol_dollar = '$' )
#set( $symbol_escape = '\' )
package ${package}.demo.domain;

import java.io.Serializable;

/**
 * @ClassName People
 * @Description (People)实体类
 * @Author vencent-lu
 * @Date 2021-09-30 17:48:23
 * @Copyright 2021 github.com/vencent-lu/giants-anemic-archetype Inc. All rights reserved.
 * @Version 1.0
 */
public class People implements Serializable {
    private static final long serialVersionUID = -18726607858820514L;

    private Integer peopleId;

    private String name;

    private Byte sex;

    private Byte age;

    private Object birthday;

    private String emailAddress;

    private String mobileNumber;

    private String identityCardNo;

    public Integer getPeopleId() {
        return peopleId;
    }

    public void setPeopleId(Integer peopleId) {
        this.peopleId = peopleId;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Byte getSex() {
        return sex;
    }

    public void setSex(Byte sex) {
        this.sex = sex;
    }

    public Byte getAge() {
        return age;
    }

    public void setAge(Byte age) {
        this.age = age;
    }

    public Object getBirthday() {
        return birthday;
    }

    public void setBirthday(Object birthday) {
        this.birthday = birthday;
    }

    public String getEmailAddress() {
        return emailAddress;
    }

    public void setEmailAddress(String emailAddress) {
        this.emailAddress = emailAddress;
    }

    public String getMobileNumber() {
        return mobileNumber;
    }

    public void setMobileNumber(String mobileNumber) {
        this.mobileNumber = mobileNumber;
    }

    public String getIdentityCardNo() {
        return identityCardNo;
    }

    public void setIdentityCardNo(String identityCardNo) {
        this.identityCardNo = identityCardNo;
    }

}
