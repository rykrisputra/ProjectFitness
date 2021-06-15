package com.fitness.main.entity;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;
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
	
	@OneToOne(cascade=CascadeType.ALL)
	 @JoinColumn(name="idUser")
	private DataUser datauser;
}
