select constraint_name from information_schema.constraint_column_usage 
where table_name = 'usuarios_acesso' and column_name = 'acesso_id'
and constraint_name  <> 'unique_acesso_user'; --bug

alter table usuarios_acesso  drop Constraint  "uk8bak9jswon2id2jbunuqlfl9e";