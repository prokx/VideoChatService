package com.hwan.firstweek.room.entity;

import com.hwan.firstweek.member.entity.Member;
import com.hwan.firstweek.util.BaseTimeEntity;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.Collection;
import java.util.LinkedList;
import java.util.List;

@Getter
@Builder
@NoArgsConstructor
@AllArgsConstructor
@Entity
public class Room extends BaseTimeEntity {
    @Id
    @Column
    @GeneratedValue(strategy = GenerationType.AUTO)
    String id;

    @Column
    String title;

    @Column
    @OneToMany(mappedBy = "room", cascade = {CascadeType.ALL})
    List<Member> members;

}
