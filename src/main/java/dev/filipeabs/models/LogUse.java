package dev.filipeabs.models;

import java.io.Serializable;
import java.sql.Timestamp;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.IdClass;
import jakarta.persistence.NamedNativeQueries;
import jakarta.persistence.NamedNativeQuery;

@Entity
@IdClass(LogUsePK.class)
@NamedNativeQueries({
        @NamedNativeQuery(name = "CONSULTA_RANGE_SOLICITACOES", query = " SELECT A.NR_USE "
                + "      , A.CD_TIP "
                + "      , A.TX_SLCT_LOG "
                + "      , A.TS_SLCT_LOG "
                + " FROM H2CRUD.SLCT_LOG A "
                + " WHERE A.NR_USE BETWEEN :solicitacaoInicial AND :solicitacaoFinal ", resultClass = LogUse.class),
        @NamedNativeQuery(name = "CONSULTA_TODAS_SOLICITACOES", query = " SELECT A.NR_USE "
                + "      , A.CD_TIP "
                + "      , A.TX_SLCT_LOG "
                + "      , A.TS_SLCT_LOG "
                + " FROM H2CRUD.SLCT_LOG A ", resultClass = LogUse.class),
        @NamedNativeQuery(name = "INSERE_SOLICITACAO", query = " INSERT INTO H2CRUD.SLCT_LOG "
                + " (NR_USE, CD_TIP, TX_SLCT_LOG, TS_SLCT_LOG) "
                + "  VALUES "
                + " (:solicitacao , 1, :textoLog , CURRENT_TIMESTAMP() )", resultClass = LogUse.class),
        @NamedNativeQuery(name = "ATUALIZA_SOLICITACAO", query = " UPDATE H2CRUD.SLCT_LOG "
                + "  SET CD_TIP = 2, TX_SLCT_LOG = :texto, TS_SLCT_LOG = CURRENT_TIMESTAMP() "
                + "  WHERE NR_USE = :solicitacao", resultClass = LogUse.class),
        @NamedNativeQuery(name = "REMOVE_SOLICITACAO", query = " DELETE FROM H2CRUD.SLCT_LOG "
                + "  WHERE NR_USE = :solicitacao", resultClass = LogUse.class),
})
public class LogUse {
    @Id
    @Column(name = "NR_USE")
    private Long numeroSolicitacao;

    @Column(name = "CD_TIP")
    private int codigoTipoTransacao;

    @Column(name = "TX_SLCT_LOG")
    private String textoDaSolicitacaoDeLog;

    @Column(name = "TS_SLCT_LOG")
    private Timestamp timestampDaSolicitacaoDeLog;

}

class LogUsePK implements Serializable {
    Long numeroSolicitacao;
}