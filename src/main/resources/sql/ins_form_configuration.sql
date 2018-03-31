INSERT INTO `form_configuration` (`id`, `default_value`, `description`, `enabled`, `field_name`, `field_type`, `form_name`, `readonly`, `remark`, `required`, `required_error`, `seq`, `src_values`, `styles`, `visible`) VALUES
  (18, '', '', True, '用户名', 'TextField', 'UserRegisterForm', False, '', True, '请输入用户名', 1, '', '', True),
  (19, '', '', True, '密码', 'PasswordField', 'UserRegisterForm', False, '', True, '请输入密码', 2, '', '', True),
  (20, '', '', True, '真实姓名', 'TextField', 'UserRegisterForm', False, '', True, '请输入真实姓名', 3, '', '', True),
  (21, '男', '', True, '性别', 'ComboBox', 'UserRegisterForm', False, '', True, '请输入性别', 4, '男|女', '', True),
  (22, '', '', True, '邮箱', 'TextField', 'UserRegisterForm', False, '', True, '请输入邮箱', 5, '', '', True),
  (23, '', '', True, '手机', 'TextField', 'UserRegisterForm', False, '', True, '请输入手机', 6, '', '', True),
  (24, '', '', True, '注册', 'Button', 'UserRegisterForm', False, '', True, '', 7, '', '', True),
  (25, '', '已有账户，去登陆', True, '去登陆', 'Button', 'UserRegisterForm', False, '', True, '', 8, '', 'link|small', True),
  (26, NULL, NULL, True, '用户名', 'TextField', 'RegisterForm', False, NULL, True, '请输入用户名', 1, NULL, NULL, True);