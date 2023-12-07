package com.example.taba42.entity;

import lombok.*;


import javax.persistence.*;


@Entity  //jpa entity 로 선언
@Table(name="Place") //table명
@NoArgsConstructor //인자 없는 기본 생성자
@AllArgsConstructor  //모든 인자 가지는 생성자
@Getter @Setter  //getter, setter 메소드
@Builder //빌더 패턴으로 생성
public class Place {
    @Id  //pk정의. 필수
    @GeneratedValue(strategy = GenerationType.AUTO) //AUTO_INCREMENT
    @Column(name="place_id", nullable = false)//테이블 컬럼과 매핑
    private Long place_id;

    @Column(name="place_type", nullable = false, length = 255)
    private String place_type;

    @Column(name="place_name", nullable = false)
    private String place_name;

    @Column(name="place_intro", nullable = false)
    private String place_intro;

    @Column(name="price", nullable = false)
    private String price;

    @Column(name="location", nullable = false)
    private String location;

    @Column(name="op_time", nullable = false)
    private String op_time;

    @Column(name="star_point", nullable = false)
    private String star_point;
}
