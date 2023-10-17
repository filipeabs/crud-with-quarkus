package dev.filipeabs.services;

import java.util.List;

import dev.filipeabs.dao.LogUseDao;
import dev.filipeabs.models.LogUse;
import jakarta.enterprise.context.ApplicationScoped;
import jakarta.inject.Inject;

@ApplicationScoped
public class LogUseService {

    @Inject
    LogUseDao dao;

    public List<LogUse> retornarLogs() {
        return dao.retornarTodos();
    }

    public LogUse retornarLogRecente(long nrUse) {
        return null;
    }

    public List<LogUse> retornarLogs(long nrUse) {
        return dao.retornarLogs(nrUse, nrUse);
    }

    public LogUse inserirLog(LogUse logUse) {
        return null;
    }

    public LogUse excluirLog(long nrUse) {
        return null;
    }

    public LogUse atualizarLog(long nrUse, LogUse logUse) {
        return null;
    }

    public LogUse excluirLogs() {
        return null;
    }

}
