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
@Table(name="user")
public class DataUser {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private long id;
	private String namaLengkap;
	private String tglLahir;
	private int tgBadan;
	private int brtBadanAwal;
	private String hp;
	private String email;
	private String username;
	private String password;
	private String image;
	
	@OneToMany(cascade = CascadeType.ALL)
	@JoinColumn(name="id_user", referencedColumnName = "id")
    private  List<History> lstHistory= new ArrayList<History>();
	
}
