package com.aaa.javademo.model;

import lombok.Data;

import javax.persistence.*;
import java.io.Serializable;
import java.util.Date;

@Data
@Entity
@Table(name = "base_user")
public class User implements Serializable {
	private static final long serialVersionUID = 2431797993269451979L;

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;

	@NotNull(message = "用户名不能为空")
	@Size(min = 3, max = 6, message = "长度为3到6")
	private String userName;

	private Integer age;

	@Column(name = "t_level")
	private boolean hightLevel;

	private Date createTime;

}
