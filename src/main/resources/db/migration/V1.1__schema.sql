create type model_type as enum (
  'TYPE1', 'TYPE2'
);

create table model (
  id     integer    not null constraint model_pkey primary key,
  name   text       not null,
  type   model_type not null,
  status varchar(8) not null
)