package com.example.shopping_project.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

import com.example.shopping_project.dto.CustomerForm;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;
import lombok.extern.slf4j.Slf4j;

// JPA를 사용해서 테이블과 매핑할 클래스는 @Entity 어노테이션을 필수로 붙여야 하고 엔티티라 부른다. 
// @Entity 어노테이션이 붙은 클래스 이름으로 springBoot가 자동으로 테이블을 만들고 클래스 내부에 선언한 필드 
// 이름으로 테이블을 구성하는 컬럼(필드)을 만들어 준다.
@Entity // 현재 클래스는 Entity로 사용되는 클래스임을 의미한다.
@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
@ToString
@Slf4j
public class Customer {
// 기본키로 사용할 필드 선언 
// 기본키를 자동으로 생성하려면 @Id 와 @GeneratedValue 어노테이션을 함께 사용해야한다.
   @Id // 필드를 기본키로 설정한다.
// @GeneratedValue // 키본키 값을 자동으로 생성한다.
   @GeneratedValue(strategy = GenerationType.IDENTITY)
   private Long id;
// 데이터를 저장할 필드 선언
   @Column // 필드를 테이블 컬럼과 매핑한다.
   private String customerId;
   @Column // 필드를 테이블 컬럼과 매핑한다.
   private String name;
   @Column
   private String zipcode;
   @Column
   private String streetAdr;
   @Column
   private String detailAdr;
   @Column
   private String email;
   @Column
   private String password;
   @Column
   private Integer phone;
   
// DTO 데이터를 Entity로 변환하는 메소드
   public static Customer toEntity(CustomerForm customerDto) {
   	log.info("Customer의 toEntity() 메소드 실행"); 
   	return new Customer(customerDto.getId(), customerDto.getCustomer_id(), customerDto.getName(), customerDto.getZipcode(), customerDto.getStreetAdr(), 
   						customerDto.getDetailAdr(), customerDto.getEmail(), customerDto.getPassword(), customerDto.getPhone()); 
   }
}



