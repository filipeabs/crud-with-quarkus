package dev.filipeabs.dao;

import jakarta.enterprise.context.RequestScoped;
import jakarta.persistence.EntityManager;
import jakarta.persistence.NoResultException;
import jakarta.persistence.PersistenceContext;
import jakarta.persistence.PersistenceException;
import jakarta.persistence.TypedQuery;

import dev.filipeabs.models.LogUse;

import java.util.ArrayList;
import java.util.List;

@RequestScoped
public class LogUseDao {

    @PersistenceContext
    EntityManager em;

    public List<LogUse> retornarTodos() {

        TypedQuery<LogUse> query = em.createNamedQuery("CONSULTA_TODAS_SOLICITACOES", LogUse.class);

        try {
            List<LogUse> resultado = query.getResultList();
            return resultado;
        } catch (NoResultException e) {
            List<LogUse> resultado = new ArrayList<>();
            return resultado;
        }
    }

    public List<LogUse> retornarLogs(long solicitacaoInicial, long solicitacaoFinal) {

        TypedQuery<LogUse> query = em.createNamedQuery("CONSULTA_PROTOCOLOS_OFERTAS", LogUse.class);

        query.setParameter("solicitacaoInicial", solicitacaoInicial);
        query.setParameter("solicitacaoFinal", solicitacaoFinal);

        try {
            List<LogUse> resultado = query.getResultList();
            return resultado;
        } catch (NoResultException e) {
            List<LogUse> resultado = new ArrayList<>();
            return resultado;
        }
    }

}
