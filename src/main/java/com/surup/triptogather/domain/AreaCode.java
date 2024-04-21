package com.surup.triptogather.domain;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import lombok.*;

@EqualsAndHashCode
@AllArgsConstructor
@NoArgsConstructor
@ToString
@Entity
public class AreaCode {
    @Id @Setter Long areaCode;
    @Column @Setter String areaName;
}
