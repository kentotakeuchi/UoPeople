-- Transaction is an action or series of actions the execution of which should lead to a consistent database state from another consistent database state. Discuss which properties that transactions should have for their correct executions. Provide two examples to support your answer.
-- The properties that transactions should have for their correct executions are atomicity, consistency, isolation, and durability, which are commonly known as ACID properties. I would like to explain each property and provide examples.

-- Atomicity:
-- Transactions should be treated as a single, indivisible unit of work. If a transaction fails to execute, the entire transaction should be rolled back and the database should remain in its original consistent state.

-- Take a banking transaction as an example, if the debit operation from one account succeeds but the credit operation to the other account fails, the entire transaction should be rolled back, and the original balances of both accounts should be restored.

-- Suppose we have two tables: Account and Transaction. We want to transfer money from one account to another. If the transaction fails, we need to roll back the entire transaction.

START TRANSACTION;

UPDATE Account SET balance = balance - 100 WHERE account_number = 'a1';
UPDATE Account SET balance = balance + 100 WHERE account_number = 'a2';

COMMIT;


-- In this case, if either of the UPDATE statements fails, the transaction will be rolled back, the changes already made to the account balances are undone and the database remains in its original consistent state.

-- Consistency:
-- Transactions should maintain the consistency of a database. A transaction should transform the database from one consistent state to the other consistent state. The database should meet all integrity constraints, validation criteria, and business rules during the transaction.

-- Isolation:
-- Transactions should be isolated from each other, even when multiple transactions are executed concurrently. Each transaction should execute as if it is the only transaction in the system. The states of a transaction are not visible to other transactions until the transaction is committed.


-- Durability:
-- Once a transaction is executed and made changes to the database, it should be permanent and survive any subsequent failures such as system crashes or power outages.

START TRANSACTION;
INSERT INTO Orders (order_id, customer_id, total_amount)
VALUES ('o1', 'c3', 100);
COMMIT;


-- Once the above transaction is committed, the inserted order record becomes a permanent part of the database even if there is a system failure immediately after the commit. The durability property guarantees that the committed changes will not be lost and can be recovered upon system recovery.

-- Reference
-- Sharma, N., Perniu, L., Chong, R. F., Iyer, A., Nandan, C., Mitea, A. C., Nonvinkere, M. & Danubianu, M. (2010). Database fundamentals. IBM Canada.