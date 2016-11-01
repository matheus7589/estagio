package com.example.root.novoteste;


import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import android.util.StringBuilderPrinter;

/**
 * Created by root on 10/10/2016.
 */

public class CriaBanco extends SQLiteOpenHelper {
    private static final String NOME_BANCO = "banco.db";

    //Campos Tabela Cadastro Domiciliar
    private static final String TABELA_DOMICILIO = "domicilio";
    private static final String ID_DOMICILIO = "_iddomicilio_";
    private static final String LATITUDE = "latitude";
    private static final String LONGITUDE = "longitude";
    private static final String NMORADORES = "n_de_moradores";
    private static final String TIPOLOGRAD = "tipo_de_logradouro";
    private static final String NOMELOGRAD = "nome_logradouro";
    private static final String COMPLEMENTO = "complemento";
    private static final String BAIRRO = "bairro";
    private static final String MUNICIPIO = "municipio";            ///USA NO INDIVIDUO TAMBEM
    private static final String CEP = "cep";
    private static final String UF = "uf";                         ///USA NO INDIVIDUO TAMBEM
    private static final String TELERESIDENCIAL = "telefone_residencial";
    private static final String TIPOLOCALIZACAO = "tipo_de_localizacao";
    private static final String TIPODOMICILIO = "tipo_de_domicilio";
    private static final String NUMEROCOMODOS = "numero_de_comodos";
    private static final String POSSE_USO_TERRRA = "posse_pso_da_terra";
    private static final String TIPOACESSO = "tipo_de_acesso";
    private static final String ENERGIA = "energia";
    private static final String ABASTECIMENTOAGUA = "abastecimento_de_agua";
    private static final String TRATAMENTOAGUA = "tratamento_de_agua";
    private static final String ESCOAMENTOBANHEIRO = "escoamento_banheiro_sanitario";
    private static final String DESTINOLIXO = "destino_do_lixo";
    private static final String ANIMAIS = "animais";
    private static final String QUANTANIMAIS = "quantidade_de_animais";


    //Campos Tabela Cadastro Individual
    private static final String TABELA_INDIVIDUO = "individuo";
    private static final String ID_INDIVIDUO = "_idindividuo_";
    private static final String FK_DOMICILIO = "fk_domicilio";    ///USA NA TABELA RESPOSAVEL
    private static final String NOME_COMPLETO = "nome";
    private static final String CARTAO_SUS = "cartao";
    private static final String DATA_NASCIMENTO = "data_de_Nascimento";
    private static final String SEXO = "sexo";
    private static final String RACACOR = "raca/cor";
    private static final String NOMEMAE = "nome_da_mae";
    private static final String NACIONALIDADE = "nacionalidade";
    private static final String TELECELULAR = "telefone_celular";
    private static final String PARENTESCO = "parentesco";
    private static final String OCUPACAO = "ocupacao";
    private static final String ESCOLACRECHE = "frequenta_escola/creche";
    private static final String CURSO = "curso_mais_elevado";
    private static final String TRABALHO = "mercado_de_trabalho";
    private static final String ORIENTACAO = "orientacao_sexual/identidade_genero";
    private static final String DEFICIENCIA = "deficiencia";


    //Campos Tabela Responsavel
    private static final String TABELA_RESPONSAVEL = "responsavel";
    private static final String FK_INDIVIDUO = "fk_individuo";


    private static final int VERSAO = 1;

    public CriaBanco(Context context){
        super(context, NOME_BANCO, null, VERSAO);
    }


    @Override
    public void onCreate(SQLiteDatabase db) {
        String sql = "CREATE TABLE "+TABELA_DOMICILIO+" ("
                + ID_DOMICILIO + " INTEGER PRIMARY KEY AUTOINCREMENT,"
                + LATITUDE + " VARCHAR(15) NOT NULL,"
                + LONGITUDE + " VARCHAR(15) NOT NULL,"
                + NMORADORES + " INTEGER NOT NULL,"
                + TIPOLOGRAD + " VARCHAR(25) NOT NULL,"
                + NOMELOGRAD + " VARCHAR(25) NOT NULL,"
                + COMPLEMENTO + " VARCHAR(25) NOT NULL,"
                + BAIRRO + " VARCHAR(25) NOT NULL,"
                + MUNICIPIO + " VARCHAR(25) NOT NULL,"
                + CEP + " INTEGER NOT NULL,"
                + UF + " VARCHAR(2) NOT NULL,"
                + TELERESIDENCIAL + " INTEGER NOT NULL,"
                + TIPOLOCALIZACAO + " VARCHAR(10) NOT NULL,"
                + TIPODOMICILIO + " VARCHAR(15) NOT NULL,"
                + NUMEROCOMODOS + " INTEGER NOT NULL,"
                + POSSE_USO_TERRRA + " VARCHAR(25) NOT NULL,"
                + TIPOACESSO + " VARCHAR(15) NOT NULL,"
                + ENERGIA + " VARCHAR(3) NOT NULL,"
                + ABASTECIMENTOAGUA + " VARCHAR(25) NOT NULL,"
                + TRATAMENTOAGUA + " VARCHAR(15) NOT NULL,"
                + ESCOAMENTOBANHEIRO + " VARCHAR(25) NOT NULL,"
                + DESTINOLIXO + " VARCHAR(15) NOT NULL,"
                + ANIMAIS + " VARCHAR(15) NOT NULL,"
                + QUANTANIMAIS + " INTEGER NOT NULL"


                +" ); CREATE TABLE " + TABELA_INDIVIDUO + " ("
                + ID_INDIVIDUO + " INTEGER PRIMARY KEY AUTOINCREMENT,"
                + FK_DOMICILIO + " INTEGER NOT NULL,"
                + NOME_COMPLETO + " VARCHAR(100) NOT NULL,"
                + CARTAO_SUS + " VARCHAR(11) NOT NULL"
                + DATA_NASCIMENTO + " NUMERIC NOT NULL,"
                + SEXO + " VARCHAR(10) NOT NULL,"
                + RACACOR + " VARCHAR(10) NOT NULL,"
                + NOMEMAE + " VARCHAR(100) NOT NULL,"
                + NACIONALIDADE + " VARCHAR(10) NOT NULL,"
                + TELECELULAR + " INTEGER NOT NULL,"
                + PARENTESCO + " VARCHAR(15) NOT NULL,"
                + OCUPACAO + " VARCHAR(15) NOT NULL,"
                + ESCOLACRECHE + " VARCHAR(3) NOT NULL,"
                + CURSO + " VARCHAR(40) NOT NULL,"
                + TRABALHO + " VARCHAR(20) NOT NULL,"
                + ORIENTACAO + " VARCHAR(10) NOT NULL,"
                + DEFICIENCIA + " VARCHAR(10) NOT NULL,"
                +" FOREIGN KEY (fk_domicilio) REFERENCES domicilio (_iddomicilio_) ON DELETE RESTRICT ON UPDATE CASCADE );" +


                "CREATE TABLE " + TABELA_RESPONSAVEL + " ("
                + FK_DOMICILIO + " INTEGER NOT NULL,"
                + FK_INDIVIDUO + " INTEGER NOT NULL,"
                + " FOREIGN KEY (fk_domicilio) REFERENCES domicilio (_iddomicilio_) ON DELETE RESTRICT ON UPDATE CASCADE,"
                + " FOREIGN KEY (fk_individuo) REFERENCES individuo (_idindividuo_) ON DELETE RESTRICT ON UPDATE CASCADE);";


        db.execSQL(sql); // SQL para adicionar/criar tabelas e valores no banco
    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int versaoAntiga, int novaVersao) {
        db.execSQL("DROP TABLE IF EXISTS" + TABELA_DOMICILIO); // Apaga a tabela, se ela existir e recria a tabela com as alterações feitas
        onCreate(db);
    }

    public static String getNomeBanco() {
        return NOME_BANCO;
    }

    public static String getTABELA() {
        return TABELA_DOMICILIO;
    }

    public static String getID() {
        return ID_DOMICILIO;
    }

    public static String getNOME() {
        return NOME_COMPLETO;
    }

    public static String getRG() {
        return CARTAO_SUS;
    }

    public static int getVERSAO() {
        return VERSAO;
    }

    public static String getTabelaDomicilio() {
        return TABELA_DOMICILIO;
    }

    public static String getIdDomicilio() {
        return ID_DOMICILIO;
    }

    public static String getLATITUDE() {
        return LATITUDE;
    }

    public static String getLONGITUDE() {
        return LONGITUDE;
    }

    public static String getNMORADORES() {
        return NMORADORES;
    }

    public static String getTIPOLOGRAD() {
        return TIPOLOGRAD;
    }

    public static String getNOMELOGRAD() {
        return NOMELOGRAD;
    }

    public static String getCOMPLEMENTO() {
        return COMPLEMENTO;
    }

    public static String getBAIRRO() {
        return BAIRRO;
    }

    public static String getMUNICIPIO() {
        return MUNICIPIO;
    }

    public static String getCEP() {
        return CEP;
    }

    public static String getUF() {
        return UF;
    }

    public static String getTELERESIDENCIAL() {
        return TELERESIDENCIAL;
    }

    public static String getTIPOLOCALIZACAO() {
        return TIPOLOCALIZACAO;
    }

    public static String getTIPODOMICILIO() {
        return TIPODOMICILIO;
    }

    public static String getNUMEROCOMODOS() {
        return NUMEROCOMODOS;
    }

    public static String getPosseUsoTerrra() {
        return POSSE_USO_TERRRA;
    }

    public static String getTIPOACESSO() {
        return TIPOACESSO;
    }

    public static String getENERGIA() {
        return ENERGIA;
    }

    public static String getABASTECIMENTOAGUA() {
        return ABASTECIMENTOAGUA;
    }

    public static String getTRATAMENTOAGUA() {
        return TRATAMENTOAGUA;
    }

    public static String getESCOAMENTOBANHEIRO() {
        return ESCOAMENTOBANHEIRO;
    }

    public static String getDESTINOLIXO() {
        return DESTINOLIXO;
    }

    public static String getANIMAIS() {
        return ANIMAIS;
    }

    public static String getQUANTANIMAIS() {
        return QUANTANIMAIS;
    }

    public static String getTabelaIndividuo() {
        return TABELA_INDIVIDUO;
    }

    public static String getIdIndividuo() {
        return ID_INDIVIDUO;
    }

    public static String getFkDomicilio() {
        return FK_DOMICILIO;
    }

    public static String getNomeCompleto() {
        return NOME_COMPLETO;
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

    public static String getRACACOR() {
        return RACACOR;
    }

    public static String getNOMEMAE() {
        return NOMEMAE;
    }

    public static String getNACIONALIDADE() {
        return NACIONALIDADE;
    }

    public static String getTELECELULAR() {
        return TELECELULAR;
    }

    public static String getPARENTESCO() {
        return PARENTESCO;
    }

    public static String getOCUPACAO() {
        return OCUPACAO;
    }

    public static String getESCOLACRECHE() {
        return ESCOLACRECHE;
    }

    public static String getCURSO() {
        return CURSO;
    }

    public static String getTRABALHO() {
        return TRABALHO;
    }

    public static String getORIENTACAO() {
        return ORIENTACAO;
    }

    public static String getDEFICIENCIA() {
        return DEFICIENCIA;
    }

    public static String getTabelaResponsavel() {
        return TABELA_RESPONSAVEL;
    }

    public static String getFkIndividuo() {
        return FK_INDIVIDUO;
    }
}


