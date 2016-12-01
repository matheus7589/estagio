package com.example.root.novoteste;


import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import android.net.ParseException;
import android.util.StringBuilderPrinter;

/**
 * Created by root on 10/10/2016.
 */

public class CriaBanco extends SQLiteOpenHelper {
    private static final String NOME_BANCO = "banco.db";

    ////////////////////////  TABELAS /////////////////////////////////////////////
    private static final String TABELA_DOMICILIO = "domicilio";
    private static final String TABELA_INDIVIDUO = "individuo";
    private static final String TABELA_FAMILIA = "familia";
    private static final String TABELA_ENDERECO = "endereco";
    private static final String TABELA_CEP = "cep";
    private static final String TABELA_BAIRRO = "bairro";
    private static final String TABELA_MUNICIPIO = "municipio";
    private static final String TABELA_ESTADO = "estado";
    private static final String TABELA_TIPOLOCALIZACAO = "tipo_localizacao";
    private static final String TABELA_TIPODOMICILIO = "tipo_domicilio";
    private static final String TABELA_MORADIA = "moradia";
    private static final String TABELA_TIPOLOGRADOURO = "tipo_logradouro";
    private static final String TABELA_CONDICAOTERRA = "condicao_terra";
    private static final String TABELA_TIPOACESSO = "tipo_acesso";
    private static final String TABELA_ABASTECIMENTOAGUA = "abastecimento_agua";
    private static final String TABELA_TRATAMENTOAGUA = "tratamento_agua";
    private static final String TABELA_DESTINOLIXO = "destino_lixo";
    private static final String TABELA_ENERGIA = "energia";
    private static final String TABELA_FORMAESCOAMENTO = "forma_escoamento";
    private static final String TABELA_TIPOANIMAL = "tipo_animal";
    private static final String TABELA_QUANTIDADEANIMAIS = "quantidade_animais";
    private static final String TABELA_ORIENTACAOSEXUAL = "orientacao_sexual";
    private static final String TABELA_SAIDACADASTRO = "saida_cadastro";
    private static final String TABELA_DEFICIENCIA = "deficiencia";
    private static final String TABELA_CRIANCAQUEMFICA = "quem_fica_com_a_crianca";
    private static final String TABELA_MERCADOTRABALHO = "situacao_mercado_trabalho";
    private static final String TABELA_CURSOMAISELEVADO = "curso_mais_elevado";
    private static final String TABELA_NACIONALIDADE = "nacionalidade";
    private static final String TABELA_RACACOR = "raca_cor";
    private static final String TABELA_PARENTESCO = "parentesco";
    ///////////////////////////////////////////////////////////////////////////////

    //Campos Tabela Cadastro Domiciliar
    private static final String NMORADORES = "n_de_moradores";
    private static final String NUMLOGRAD = "numero_logradouro";
    private static final String TELERESIDENCIAL = "telefone_residencial";
    private static final String NUMEROCOMODOS = "numero_de_comodos";
    private static final String QUANTANIMAIS = "quantidade_de_animais";


    //Campos Tabela Cadastro Individual
    private static final String FK_DOMICILIO = "fk_domicilio";    ///USA NA TABELA FAMILIA
    private static final String NOME_COMPLETO = "nome";
    private static final String NOME_SOCIAL = "nome_social";
    private static final String CARTAO_SUS = "cartao";
    private static final String DATA_NASCIMENTO = "data_de_Nascimento";
    private static final String SEXO = "sexo";
    private static final String NOMEMAE = "nome_da_mae";
    private static final String TELECELULAR = "telefone_celular";
    private static final String OCUPACAO = "ocupacao";
    private static final String ESCOLACRECHE = "frequenta_escola/creche";
    private static final String DATAINICIORESIDENCIA = "inicio_residencia";
    private static final String DATAFIMRESIDENCIA = "fim_residencia";
    private static final String CUIDADORTRADICIONAL = "cuidador_tredicional";
    private static final String GRUPOCOMUNITARIO = "grupo_comunitario";
    private static final String COMUNIDADETRADICIONAL = "comunidade_tradicional";
    private static final String PLANOSAUDE = "plano_saude";


    //Campos Tabela Familia
    private static final String FK_INDIVIDUO = "fk_individuo";

    //Campos Tabela Endereco
    private static  final String LATITUDE = "latitude";
    private static final String LONGITUDE = "longitude";
    private static final String NOMELOGRAD = "nome_logradouro";
    private static final String COMPLEMENTO = "complemento";
    private static final String FK_CEP = "fk_cep";
    private static final String FK_BAIRRO = "fk_bairro";
    private static final String FK_MUNICIPIO = "fk_municipio";
    private static final String FK_ESTADO = "fk_estado";

    //Campo genérico
    private static final String DESCRICAO = "descricao";
    private static final String ID = "_id";

    //Campo Quantidade de Animais
    private static final String FK_ANIMAL = "fk_animal";

    ////////////////////////////////////////// DOMICILIO /////////////////////////////////////////////////
            private static final String CREATE_TABLE_DOMICILIO = "CREATE TABLE "+TABELA_DOMICILIO+" ("
            + ID + " INTEGER PRIMARY KEY AUTOINCREMENT,"
            + NMORADORES + " INTEGER,"
            + NUMLOGRAD + " INTEGER,"
            + TELERESIDENCIAL + " INTEGER,"
            + CARTAO_SUS + " VARCHAR(11),"
            + NUMEROCOMODOS + " INTEGER,"
            + FK_INDIVIDUO + " INTEGER,"
            + QUANTANIMAIS + " INTEGER)"
            + " FOREIGN KEY (fk_individuo) REFERENCES familia (fk_individuo) ON DELETE RESTRICT ON UPDATE CASCADE )";

    //////////////////////////////////////////// INDIVIDUO ///////////////////////////////////////
            private static final String CREATE_TABLE_INDIVIDUO = "CREATE TABLE " + TABELA_INDIVIDUO + " ("
            + ID + " INTEGER PRIMARY KEY AUTOINCREMENT,"
            + FK_DOMICILIO + " INTEGER,"
            + NOME_COMPLETO + " VARCHAR(100),"
            + NOME_SOCIAL + " VARCHAR(100),"
            + CARTAO_SUS + " VARCHAR(11),"
            + DATA_NASCIMENTO + " VARCHAR(10),"
            + SEXO + " VARCHAR(1),"
            + NOMEMAE + " VARCHAR(100),"
            + TELECELULAR + " INTEGER,"
            + OCUPACAO + " VARCHAR(15),"
            + DATAINICIORESIDENCIA + " VARCHAR(10),"
            + DATAFIMRESIDENCIA + " VARCHAR(10),"
            + ESCOLACRECHE + " VARCHAR(1),"
            + CUIDADORTRADICIONAL + " VARCHAR(1),"
            + GRUPOCOMUNITARIO + " VARCHAR(1),"
            + COMUNIDADETRADICIONAL + " VARCHAR(1),"
            + PLANOSAUDE + " VARCHAR(1),"
            +" FOREIGN KEY (fk_domicilio) REFERENCES familia (fk_domicilio) ON DELETE RESTRICT ON UPDATE CASCADE )";

    /////////////////////////////////////////// FAMILIA  //////////////////////////////////////////////
                private static final String CREATE_TABLE_FAMILIA = "CREATE TABLE " + TABELA_FAMILIA + " ("
                + ID + " INTEGER PRIMARY KEY AUTOINCREMENT,"
                + FK_DOMICILIO + " INTEGER PRIMARY KEY,"
                + FK_INDIVIDUO + " INTEGER PRIMARY KEY,"
                + " FOREIGN KEY (fk_domicilio) REFERENCES domicilio (_id) ON DELETE RESTRICT ON UPDATE CASCADE,"
                + " FOREIGN KEY (fk_individuo) REFERENCES individuo (_id) ON DELETE RESTRICT ON UPDATE CASCADE)";

    //////////////////////////////////////////// ENDERECO ////////////////////////////////////////////////
                private static final String CREATE_TABLE_ENDERECO = "CREATE TABLE " + TABELA_ENDERECO + " ("
                + ID + " INTEGER PRIMARY KEY AUTOINCREMENT,"
                + LATITUDE + " REAL,"
                + LONGITUDE + " REAL,"
                + NOMELOGRAD + " VARCHAR(25),"
                + COMPLEMENTO + " VARCHAR(25),"
                + FK_BAIRRO + " INTERGER,"
                + FK_MUNICIPIO + " INTEGER,"
                + FK_ESTADO + " INTEGER,"
                + FK_CEP + " INTEGER,"
                + " FOREIGN KEY (fk_bairro) REFERENCES bairro (_id) ON DELETE RESTRICT ON UPDATE CASCADE,"
                + " FOREIGN KEY (fk_municipio) REFERENCES municipio (_id) ON DELETE RESTRICT ON UPDATE CASCADE,"
                + " FOREIGN KEY (fk_estado) REFERENCES estado (_id) ON DELETE RESTRICT ON UPDATE CASCADE,"
                + " FOREIGN KEY (fk_cep) REFERENCES cep (_id) ON DELETE RESTRICT ON UPDATE CASCADE)";

    ////////////////////////////////////////// BAIRRO /////////////////////////////////////////////////
            private static final String CREATE_TABLE_BAIRRO = "CREATE TABLE " + TABELA_BAIRRO + " ("
            + ID + " INTEGER PRIMARY KEY AUTOINCREMENT,"
            + DESCRICAO + " VARCHAR(50));";

    //////////////////////////////////////// MUNICIPIO /////////////////////////////////////////////
               private  static  final String CREATE_TABLE_MUNICIPIO = "CREATE TABLE " + TABELA_MUNICIPIO + " ("
                + ID + "INTEGER PRIMARY KEY AUTOINCREMENT,"
                + DESCRICAO + "VARCHAR(50))";

                ///////////////////////////////////////// ESTADO ////////////////////////////////////////////////
                private static final String CREATE_TABLE_ESTADO =  "CREATE TABLE " + TABELA_ESTADO + " ("
                + ID + "INTEGER PRIMARY KEY,"
                + DESCRICAO + "VARCHAR(50))";

                ///////////////////////////////////////// CEP ////////////////////////////////////////////////////
                private  static final String CREATE_TABLE_CEP = "CREATE TABLE " + TABELA_CEP + " ("
                + ID + "INTEGER PRIMARY KEY AUTOINCREMENT,"
                + DESCRICAO + "VARCHAR(50))";

                ///////////////////////////////////////// TIPO DOMICILIO //////////////////////////////////////////
                private static final String CREATE_TABLE_TIPO_DOMICILIO = "CREATE TABLE " + TABELA_TIPODOMICILIO + " ("
                + ID + "INTEGER PRIMARY KEY AUTOINCREMENT,"
                + DESCRICAO + "VARCHAR(50))";

                //////////////////////////////////////// ABASTECIMENTO AGUA /////////////////////////////////////
                private static final String CREATE_TABLE_ABASTECIMENTO_AGUA = "CREATE TABLE " + TABELA_ABASTECIMENTOAGUA + " ("
                + ID + "INTEGER PRIMARY KEY AUTOINCREMENT,"
                + DESCRICAO + "VARCHAR(50))";

                /////////////////////////////////////// DESTINO LIXO /////////////////////////////////////////////
                private static final String CREATE_TABLE_DESTINO_LIXO = "CREATE TABLE " + TABELA_DESTINOLIXO + " ("
                + ID + "INTEGER PRIMARY KEY AUTOINCREMENT,"
                + DESCRICAO + "VARCHAR(50))";

                /////////////////////////////////////// CONDIÇÃO TERRA ////////////////////////////////////////////////
                private static final String CREATE_TABLE_CONDICAO_TERRA = "CREATE TABLE " + TABELA_CONDICAOTERRA + " ("
                + ID + "INTEGER PRIMARY KEY AUTOINCREMENT,"
                + DESCRICAO + "VARCHAR(50))";

                /////////////////////////////////////// TIPO LOCALIZACAO //////////////////////////////////////////////
                private static final String CREATE_TABLE_TIPO_LOCALIZACAO = "CREATE TABLE " + TABELA_TIPOLOCALIZACAO + " ("
                + ID + "INTEGER PRIMARY KEY AUTOINCREMENT,"
                + DESCRICAO + "VARCHAR(50))";

                ////////////////////////////////////// TRATAMENTO AGUA ///////////////////////////////////////////////
                private static final String CREATE_TABLE_TRATAMENTO_AGUA = "CREATE TABLE " + TABELA_TRATAMENTOAGUA + " ("
                + ID + "INTEGER PRIMARY KEY AUTOINCREMENT,"
                + DESCRICAO + "VARCHAR(50))";

                ////////////////////////////////////// MORADIA /////////////////////////////////////////////////////
                private static final String CREATE_TABLE_MORADIA = "CREATE TABLE " + TABELA_MORADIA + " ("
                + ID + "INTEGER PRIMARY KEY AUTOINCREMENT,"
                + DESCRICAO + "VARCHAR(50))";

                ///////////////////////////////////// ESCOAMENTO ///////////////////////////////////////////////////
                private static final String CREATE_TABLE_ESCOAMENTO = "CREATE TABLE " + TABELA_FORMAESCOAMENTO + " ("
                + ID + "INTEGER PRIMARY KEY AUTOINCREMENT,"
                + DESCRICAO + "VARCHAR(50))";

                //////////////////////////////////// ENERGIA //////////////////////////////////////////////////////
                private static final String CREATE_TABLE_ENERGIA = "CREATE TABLE " + TABELA_ENERGIA + " ("
                + ID + "INTEGER PRIMARY KEY AUTOINCREMENT,"
                + DESCRICAO + "VARCHAR(50))";

                ////////////////////////////////////// TIPO ACESSO ///////////////////////////////////////////////
                private static final String CREATE_TABLE_TIPO_ACESSO = "CREATE TABLE " + TABELA_TIPOACESSO + " ("
                + ID + "INTEGER PRIMARY KEY AUTOINCREMENT,"
                + DESCRICAO + "VARCHAR(50))";

                /////////////////////////////////////// TIPO LOGRADOURO //////////////////////////////////////////
                private static final String CREATE_TABLE_TIPO_LOGRADOURO = "CREATE TABLE " + TABELA_TIPOLOGRADOURO + " ("
                + ID + "INTEGER PRIMARY KEY AUTOINCREMENT,"
                + DESCRICAO + "VARCHAR(50))";

                /////////////////////////////////////// TIPO ANIMAL /////////////////////////////////////////////
                private static final String CREATE_TABLE_TIPO_ANIMAL = "CREATE TABLE " + TABELA_TIPOANIMAL + " ("
                + ID + "INTEGER PRIMARY KEY AUTOINCREMENT,"
                + DESCRICAO + "VARCHAR(50))";

                /////////////////////////////////////// QUANTIDADE ANIMAIS ///////////////////////////////////////
                private static final String CREATE_TABLE_QUANTIDADE_ANIMAIS = "CREATE TABLE " + TABELA_QUANTIDADEANIMAIS + " ("
                + ID + "INTEGER PRIMARY KEY AUTOINCREMENT,"
                + FK_DOMICILIO + " INTEGER PRIMARY KEY NOT NULL,"
                + FK_ANIMAL + " INTEGER PRIMARY KEY NOT NULL,"
                + " FOREIGN KEY (fk_domicilio) REFERENCES domicilio (_id) ON DELETE RESTRICT ON UPDATE CASCADE,"
                + " FOREIGN KEY (fk_animal) REFERENCES animal (_id) ON DELET RESTRICT ON UPDATE CASCADE)";

                /////////////////////////////////////// ORIENTAÇÃO SEXUAL ////////////////////////////////////////////
                private static final String CREATE_TABLE_ORIENTACAO_SEXUAL = "CREATE TABLE " + TABELA_ORIENTACAOSEXUAL + " ("
                + ID + "INTEGER PRIMARY KEY AUTOINCREMENT,"
                + DESCRICAO + "VARCHAR(50))";

                /////////////////////////////////////// SAIDA CADASTRO //////////////////////////////////////////////
                private static final String CREATE_TABLE_SAIDA_CADASTRO = "CREATE TABLE " + TABELA_SAIDACADASTRO + " ("
                + ID + "INTEGER PRIMARY KEY AUTOINCREMENT,"
                + DESCRICAO + "VARCHAR(50))";

                //////////////////////////////////////// DEFICIENCIA ////////////////////////////////////////////////
                private static final String CREATE_TABLE_DEFICIENCIA = "CREATE TABLE " + TABELA_TIPOACESSO + " ("
                + ID + "INTEGER PRIMARY KEY AUTOINCREMENT,"
                + DESCRICAO + "VARCHAR(50))";

                /////////////////////////////////////// PARENTESCO //////////////////////////////////////////////////
                private static final String CREATE_TABLE_PARENTESCO = "CREATE TABLE " + TABELA_PARENTESCO + " ("
                + ID + "INTEGER PRIMARY KEY AUTOINCREMENT,"
                + DESCRICAO + "VARCHAR(50))";

                //////////////////////////////////////// RAÇA/COR //////////////////////////////////////////////////
                private static final String CREATE_TABLE_RACA = "CREATE TABLE " + TABELA_RACACOR + " ("
                + ID + "INTEGER PRIMARY KEY AUTOINCREMENT,"
                + DESCRICAO + "VARCHAR(50))";

                /////////////////////////////////////// NACIONALIDADE ///////////////////////////////////////////////
                private static final String CREATE_TABLE_NAICIONALIDADE = "CREATE TABLE " + TABELA_NACIONALIDADE + " ("
                + ID + "INTEGER PRIMARY KEY AUTOINCREMENT,"
                + DESCRICAO + "VARCHAR(50))";

                ////////////////////////////////////// CURSO MAIS ELEVADO //////////////////////////////////////////////
                private static final String CREATE_TABLE_CURSO_MAIS_ELEVADO = "CREATE TABLE " + TABELA_CURSOMAISELEVADO + " ("
                + ID + "INTEGER PRIMARY KEY AUTOINCREMENT,"
                + DESCRICAO + "VARCHAR(50))";

                /////////////////////////////////////// SITUAÇÃO MERCADO DE TRABALHO ///////////////////////////////////
                private static final String CREATE_TABLE_MERCADO_TRABALHO = "CREATE TABLE " + TABELA_MERCADOTRABALHO + " ("
                + ID + "INTEGER PRIMARY KEY AUTOINCREMENT,"
                + DESCRICAO + "VARCHAR(50))";

                /////////////////////////////////////// QUEM FICA COM A CRIANÇA ////////////////////////////////////////
                private static final String CREATE_TABLE_QUEM_FICA_CRIANCA = "CREATE TABLE " + TABELA_CRIANCAQUEMFICA + " ("
                + ID + "INTEGER PRIMARY KEY AUTOINCREMENT,"
                + DESCRICAO + "VARCHAR(50))";

    private static final int VERSAO = 2;

    public CriaBanco(Context context){
        super(context, NOME_BANCO, null, VERSAO);
    }


    @Override
    public void onCreate(SQLiteDatabase db) {

        db.execSQL(CREATE_TABLE_DOMICILIO); // SQL para adicionar/criar tabelas e valores no banco
        db.execSQL(CREATE_TABLE_BAIRRO);
        db.execSQL(CREATE_TABLE_INDIVIDUO);
        db.execSQL(CREATE_TABLE_FAMILIA);
        db.execSQL(CREATE_TABLE_ENDERECO);
        db.execSQL(CREATE_TABLE_MUNICIPIO);
        db.execSQL(CREATE_TABLE_ESTADO);
        db.execSQL(CREATE_TABLE_CEP);
        db.execSQL(CREATE_TABLE_TIPO_DOMICILIO);
        db.execSQL(CREATE_TABLE_ABASTECIMENTO_AGUA);
        db.execSQL(CREATE_TABLE_DESTINO_LIXO);
        db.execSQL(CREATE_TABLE_CONDICAO_TERRA);
        db.execSQL(CREATE_TABLE_TIPO_LOCALIZACAO);
        db.execSQL(CREATE_TABLE_TRATAMENTO_AGUA);
        db.execSQL(CREATE_TABLE_MORADIA);
        db.execSQL(CREATE_TABLE_ESCOAMENTO);
        db.execSQL(CREATE_TABLE_ENERGIA);
        db.execSQL(CREATE_TABLE_TIPO_ACESSO);
        db.execSQL(CREATE_TABLE_TIPO_LOGRADOURO);
        db.execSQL(CREATE_TABLE_TIPO_ANIMAL);
        db.execSQL(CREATE_TABLE_QUANTIDADE_ANIMAIS);
        db.execSQL(CREATE_TABLE_ORIENTACAO_SEXUAL);
    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int versaoAntiga, int novaVersao) {
        db.execSQL("DROP TABLE IF EXISTS " + TABELA_DOMICILIO);// Apaga a tabela, se ela existir e recria a tabela com as alterações feitas
        db.execSQL("DROP TABLE IF EXISTS " + TABELA_BAIRRO);
        onCreate(db);
    }

    public static String getNomeBanco() {
        return NOME_BANCO;
    }

    public static String getTabelaDomicilio() {
        return TABELA_DOMICILIO;
    }

    public static String getTabelaIndividuo() {
        return TABELA_INDIVIDUO;
    }

    public static String getTabelaFamilia() {
        return TABELA_FAMILIA;
    }

    public static String getTabelaEndereco() {
        return TABELA_ENDERECO;
    }

    public static String getTabelaCep() {
        return TABELA_CEP;
    }

    public static String getTabelaBairro() {
        return TABELA_BAIRRO;
    }

    public static String getTabelaMunicipio() {
        return TABELA_MUNICIPIO;
    }

    public static String getTabelaEstado() {
        return TABELA_ESTADO;
    }

    public static String getTabelaTipolocalizacao() {
        return TABELA_TIPOLOCALIZACAO;
    }

    public static String getTabelaTipodomicilio() {
        return TABELA_TIPODOMICILIO;
    }

    public static String getTabelaMoradia() {
        return TABELA_MORADIA;
    }

    public static String getTabelaTipologradouro() {
        return TABELA_TIPOLOGRADOURO;
    }

    public static String getTabelaCondicaoterra() {
        return TABELA_CONDICAOTERRA;
    }

    public static String getTabelaTipoacesso() {
        return TABELA_TIPOACESSO;
    }

    public static String getTabelaAbastecimentoagua() {
        return TABELA_ABASTECIMENTOAGUA;
    }

    public static String getTabelaTratamentoagua() {
        return TABELA_TRATAMENTOAGUA;
    }

    public static String getTabelaDestinolixo() {
        return TABELA_DESTINOLIXO;
    }

    public static String getTabelaEnergia() {
        return TABELA_ENERGIA;
    }

    public static String getTabelaFormaescoamento() {
        return TABELA_FORMAESCOAMENTO;
    }

    public static String getTabelaTipoanimal() {
        return TABELA_TIPOANIMAL;
    }

    public static String getTabelaQuantidadeanimais() {
        return TABELA_QUANTIDADEANIMAIS;
    }

    public static String getTabelaOrientacaosexual() {
        return TABELA_ORIENTACAOSEXUAL;
    }

    public static String getTabelaSaidacadastro() {
        return TABELA_SAIDACADASTRO;
    }

    public static String getTabelaDeficiencia() {
        return TABELA_DEFICIENCIA;
    }

    public static String getTabelaCriancaquemfica() {
        return TABELA_CRIANCAQUEMFICA;
    }

    public static String getTabelaMercadotrabalho() {
        return TABELA_MERCADOTRABALHO;
    }

    public static String getTabelaCursomaiselevado() {
        return TABELA_CURSOMAISELEVADO;
    }

    public static String getTabelaNacionalidade() {
        return TABELA_NACIONALIDADE;
    }

    public static String getTabelaRacacor() {
        return TABELA_RACACOR;
    }

    public static String getTabelaParentesco() {
        return TABELA_PARENTESCO;
    }

    public static String getNMORADORES() {
        return NMORADORES;
    }

    public static String getNUMLOGRAD() {
        return NUMLOGRAD;
    }

    public static String getTELERESIDENCIAL() {
        return TELERESIDENCIAL;
    }

    public static String getNUMEROCOMODOS() {
        return NUMEROCOMODOS;
    }

    public static String getQUANTANIMAIS() {
        return QUANTANIMAIS;
    }

    public static String getFkDomicilio() {
        return FK_DOMICILIO;
    }

    public static String getNomeCompleto() {
        return NOME_COMPLETO;
    }

    public static String getNomeSocial() {
        return NOME_SOCIAL;
    }

    public static String getCartaoSus() {
        return CARTAO_SUS;
    }

    public static String getDataNascimento() {
        return DATA_NASCIMENTO;
    }

    public static String getSEXO() {
        return SEXO;
    }

    public static String getNOMEMAE() {
        return NOMEMAE;
    }

    public static String getTELECELULAR() {
        return TELECELULAR;
    }

    public static String getOCUPACAO() {
        return OCUPACAO;
    }

    public static String getESCOLACRECHE() {
        return ESCOLACRECHE;
    }

    public static String getDATAINICIORESIDENCIA() {
        return DATAINICIORESIDENCIA;
    }

    public static String getDATAFIMRESIDENCIA() {
        return DATAFIMRESIDENCIA;
    }

    public static String getCUIDADORTRADICIONAL() {
        return CUIDADORTRADICIONAL;
    }

    public static String getGRUPOCOMUNITARIO() {
        return GRUPOCOMUNITARIO;
    }

    public static String getCOMUNIDADETRADICIONAL() {
        return COMUNIDADETRADICIONAL;
    }

    public static String getPLANOSAUDE() {
        return PLANOSAUDE;
    }

    public static String getFkIndividuo() {
        return FK_INDIVIDUO;
    }

    public static String getLATITUDE() {
        return LATITUDE;
    }

    public static String getLONGITUDE() {
        return LONGITUDE;
    }

    public static String getNOMELOGRAD() {
        return NOMELOGRAD;
    }

    public static String getCOMPLEMENTO() {
        return COMPLEMENTO;
    }

    public static String getFkCep() {
        return FK_CEP;
    }

    public static String getFkBairro() {
        return FK_BAIRRO;
    }

    public static String getFkMunicipio() {
        return FK_MUNICIPIO;
    }

    public static String getFkEstado() {
        return FK_ESTADO;
    }

    public static String getDESCRICAO() {
        return DESCRICAO;
    }

    public static String getID() {
        return ID;
    }

    public static String getFkAnimal() {
        return FK_ANIMAL;
    }
}


