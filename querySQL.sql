SELECT 
  * 
FROM 
  public.domicilio, 
  public.abastecimento_agua, 
  public.animal_domicilio, 
  public.bairro, 
  public.cargo, 
  public.condicao_terra, 
  public.destino_lixo, 
  public.endereco, 
  public.energia, 
  public.equipe, 
  public.especialidade, 
  public.estado, 
  public.forma_escoamento, 
  public.funcionamento, 
  public.microarea, 
  public.municipio, 
  public.servidores, 
  public.situacao_moradia, 
  public.tipo_acesso, 
  public.tipo_animal, 
  public.tipo_domicilio, 
  public.tipo_localizacao, 
  public.tratamento_agua, 
  public.unidade_saude, 
  public.microarea
WHERE 
  domicilio.fk_animal_domicilio = animal_domicilio.id_animal_domicilio AND
  abastecimento_agua.id_abastecimento_agua = domicilio.fk_abastecimento_agua AND
  animal_domicilio.fk_tipo_animal = tipo_animal.id_tipo_animal AND
  bairro.id_bairro = endereco.fk_bairro AND
  cargo.fk_especialidade = especialidade.id_especialidade AND
  condicao_terra.id_condicao = domicilio.fk_condicao_terra AND
  destino_lixo.id_destino = domicilio.fk_destino AND
  endereco.id_endereco = domicilio.fk_endereco AND
  energia.id_energia = domicilio.fk_energia AND
  equipe.fk_servidores = servidores.id_servidores AND
  equipe.fk_unidade = unidade_saude.id_unidade_saude AND
  estado.id_estado = endereco.fk_estado AND
  forma_escoamento.id_escoamento = domicilio.fk_escoamento AND
  municipio.id_municipio = endereco.fk_municipio AND
  servidores.fk_microarea = microarea.id_microarea AND
  servidores.fk_cargo = cargo.id_cargo AND
  situacao_moradia.id_situacao_moradia = domicilio.fk_situacao_moradia AND
  tipo_acesso.id_tipo_acesso = domicilio.fk_tipo_acesso AND
  tipo_domicilio.id = domicilio.fk_tipo_domicilio AND
  tipo_localizacao.id_tipo_localizacao = domicilio.fk_tipo_localizacao AND
  tratamento_agua.id_tratamento_agua = domicilio.fk_tratamento_agua AND
  unidade_saude.id_unidade_saude = domicilio.fk_unidade_saude AND
  unidade_saude.fk_funcionamento = funcionamento.id_funcionamento AND
  unidade_saude.fk_equipe = equipe.id_equipe AND
  unidade_saude.fk_endereco = endereco.id_endereco;
