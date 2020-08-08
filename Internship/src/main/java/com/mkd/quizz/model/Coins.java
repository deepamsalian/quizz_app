package com.mkd.quizz.model;

import java.io.Serializable;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;

import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;


@Entity
@Table(name = "coins")
public class Coins implements Serializable {
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	@Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long coins_id;
	
	@NotNull
	@Column(name="rank_id")
	private int rank_id;

	
	@NotNull
	@Column(name="no_of_coins")
	private int no_of_coins=0;
	
	@OneToOne(fetch=FetchType.LAZY,cascade=CascadeType.ALL)
	@JoinColumn(name="user_id",nullable=false)
	private User user;
	
	public Coins()
	{
		
	}

	public Coins( int rank_id,  int no_of_coins, User user) {
		super();
		this.rank_id = rank_id;
		this.no_of_coins = no_of_coins;
		this.user = user;
	}

	public Long getCoins_id() {
		return coins_id;
	}

	public void setCoins_id(Long coins_id) {
		this.coins_id = coins_id;
	}

	public int getRank_id() {
		return rank_id;
	}

	public void setRank_id(int rank_id) {
		this.rank_id = rank_id;
	}

	public int getNo_of_coins() {
		return no_of_coins;
	}

	public void setNo_of_coins(int no_of_coins) {
		this.no_of_coins = no_of_coins;
	}

	public User getUser() {
		return user;
	}

	public void setUser(User user) {
		this.user = user;
	}
	
	
}
