package com.fitness.main.entity;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor

@Entity
@Table(name="history")
public class History {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private long idHistory;
	private String tgl;
	private int skor;
	private int kalori;
	private String bbIdeal;
}