package com.honglinktech.zbgj.base;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.jdbc.datasource.DataSourceTransactionManager;
import org.springframework.transaction.TransactionDefinition;
import org.springframework.transaction.TransactionException;
import org.springframework.transaction.support.DefaultTransactionStatus;
import org.springframework.transaction.support.TransactionSynchronization;

import javax.sql.DataSource;
import java.util.List;

/**
 * Created by Administrator on 2018/6/2/002.
 */
public class TransactionManager extends DataSourceTransactionManager {

    protected final Logger logger = LogManager.getLogger(getClass());

    @Override
    protected void registerAfterCompletionWithExistingTransaction(Object transaction, List<TransactionSynchronization> synchronizations) throws TransactionException {
        super.registerAfterCompletionWithExistingTransaction(transaction, synchronizations);
    }

    public TransactionManager() {
        super();
        logger.info("=============TransactionManager===============");
        System.out.println("==========s========TransactionManager===================");
    }

    public TransactionManager(DataSource dataSource) {
        super(dataSource);
        logger.info("=============TransactionManager==============="+dataSource);
        System.out.println("==========s========TransactionManager==================="+dataSource);
    }

    @Override
    public void setDataSource(DataSource dataSource) {
        logger.info("=============setDataSource===============");
        System.out.println("==========s========setDataSource===================");
        super.setDataSource(dataSource);
    }

    @Override
    public DataSource getDataSource() {
        return super.getDataSource();
    }

    @Override
    public void afterPropertiesSet() {
        super.afterPropertiesSet();
    }

    @Override
    public Object getResourceFactory() {
        return super.getResourceFactory();
    }

    @Override
    protected Object doGetTransaction() {
        return super.doGetTransaction();
    }

    @Override
    protected boolean isExistingTransaction(Object transaction) {
        return super.isExistingTransaction(transaction);
    }

    @Override
    protected void doBegin(Object transaction, TransactionDefinition definition) {
        super.doBegin(transaction, definition);
    }

    @Override
    protected Object doSuspend(Object transaction) {
        return super.doSuspend(transaction);
    }

    @Override
    protected void doResume(Object transaction, Object suspendedResources) {
        super.doResume(transaction, suspendedResources);
    }

    @Override
    protected void doCommit(DefaultTransactionStatus status) {
        super.doCommit(status);
    }

    @Override
    protected void doRollback(DefaultTransactionStatus status) {
        super.doRollback(status);
    }

    @Override
    protected void doSetRollbackOnly(DefaultTransactionStatus status) {
        super.doSetRollbackOnly(status);
    }

    @Override
    protected void doCleanupAfterCompletion(Object transaction) {
        super.doCleanupAfterCompletion(transaction);
    }

    @Override
    protected DefaultTransactionStatus newTransactionStatus(TransactionDefinition definition, Object transaction, boolean newTransaction, boolean newSynchronization, boolean debug, Object suspendedResources) {
        return super.newTransactionStatus(definition, transaction, newTransaction, newSynchronization, debug, suspendedResources);
    }

    @Override
    protected void prepareSynchronization(DefaultTransactionStatus status, TransactionDefinition definition) {
        super.prepareSynchronization(status, definition);
    }

    @Override
    protected int determineTimeout(TransactionDefinition definition) {
        return super.determineTimeout(definition);
    }

    @Override
    protected boolean useSavepointForNestedTransaction() {
        return super.useSavepointForNestedTransaction();
    }

    @Override
    protected boolean shouldCommitOnGlobalRollbackOnly() {
        return super.shouldCommitOnGlobalRollbackOnly();
    }

    @Override
    protected void prepareForCommit(DefaultTransactionStatus status) {
        super.prepareForCommit(status);
    }
}
