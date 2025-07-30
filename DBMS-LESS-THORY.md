# SQL Interview Guide

## 1. GROUP BY + HAVING vs WHERE

- **WHERE** filters rows *before* grouping.
- **GROUP BY** groups rows.
- **HAVING** filters groups *after* aggregation.

```sql
-- Example:
SELECT department, COUNT(*)
FROM employees
WHERE salary > 50000  -- filter before grouping
GROUP BY department
HAVING COUNT(*) > 5;   -- filter after grouping
```

## 2. Recursive CTEs

- Common Table Expressions that call themselves to solve hierarchical problems (e.g., org charts).
- Typically used with `UNION ALL` and a stop condition.
**Syntax:**
```sql
WITH RECURSIVE cte_name AS (
  -- Anchor member
  SELECT ...
  FROM ...
  WHERE ...

  UNION ALL

  -- Recursive member
  SELECT ...
  FROM cte_name
  JOIN ...
  ON ...
)
SELECT * FROM cte_name;
```
```sql
WITH RECURSIVE employee_tree AS (
  SELECT id, manager_id, name FROM employees WHERE manager_id IS NULL
  UNION ALL
  SELECT e.id, e.manager_id, e.name FROM employees e
  JOIN employee_tree t ON e.manager_id = t.id
)
SELECT * FROM employee_tree;
```

## 3. Subqueries

- **Non-Correlated**: Can run independently.
- **Correlated**: Depends on the outer query.

```sql
-- Non-Correlated
SELECT name FROM employees WHERE department_id = (SELECT id FROM departments WHERE name = 'HR');

-- Correlated
SELECT e.name FROM employees e WHERE salary > (SELECT AVG(salary) FROM employees WHERE department_id = e.department_id);
```

## 4. Window Functions

- They let you perform calculations across rows related to the current row, without collapsing the result set.

  - ROW_NUMBER(): Unique row number per partition

  - RANK(): Gives same rank for ties, skips next numbers

  - DENSE_RANK(): No gaps in ranks

  - LEAD() / LAG(): Access next/previous row’s values

```sql
SELECT name, salary,
  ROW_NUMBER() OVER (PARTITION BY department_id ORDER BY salary DESC) AS rn,
  LAG(salary) OVER (ORDER BY hire_date) AS prev_salary
FROM employees;
```

## 5. NULL Handling

- `NULL` = Unknown. Comparisons involving `NULL` yield `NULL`.
- Use `IS NULL` or `IS NOT NULL`.
- Aggregates like `COUNT(column)` skip NULLs.

## 6. CASE-based Logic

```sql
SELECT
    N,
    CASE
        WHEN P IS NULL THEN 'Root'
        WHEN N IN (SELECT P FROM BST WHERE P IS NOT NULL) THEN 'Inner'
        ELSE 'Leaf'
    END AS Node_Type
FROM
    BST
ORDER BY
    N;
```

## 7. EXISTS vs IN vs ANY vs ALL

- **IN**: Matches any value in a list.
- **EXISTS**: Returns true if the subquery returns any row.
- **ANY**: True if comparison is true for *any* row.
- **ALL**: True if comparison is true for *all* rows.

```sql
-- EXISTS example
SELECT name FROM employees e WHERE EXISTS (SELECT 1 FROM departments d WHERE d.manager_id = e.id);
```

## 8. Index Performance

- Indexes speed up `WHERE`, `JOIN`, `ORDER BY`.
- B-Trees allow logarithmic lookups.
- But too many indexes slow down `INSERT`, `UPDATE`.

### 🔷 1NF
- No repeating groups
- All attributes contain atomic values

### 🔷 2NF
- In 1NF
- No **partial dependency** on a composite primary key

### 🔷 3NF
- In 2NF
- No **transitive dependency** on non-prime attributes

### 🔷 BCNF
- In 3NF
- Every determinant is a candidate key

### 🔑 Keys
| Type            | Description |
|-----------------|-------------|
| Primary Key     | Uniquely identifies rows |
| Candidate Key   | Any column/set that can be a primary key |
| Foreign Key     | References primary key in another table |
| Surrogate Key   | Artificial ID (e.g., auto-increment) |
| Natural Key     | Comes from actual data (e.g., email) |

---

## 4. ACID Properties (Example: Payment System)

| Property   | Meaning | Example |
|------------|---------|---------|
| Atomicity  | All-or-nothing | Debit sender and credit receiver must both succeed |
| Consistency| Valid state transitions | No negative balances, valid account numbers |
| Isolation  | Transactions don’t interfere | Two transfers don’t corrupt each other |
| Durability | Changes persist after crash | Once committed, payment is not lost |

---

## 5. Isolation Levels

| Level             | Dirty Reads | Non-Repeatable Reads | Phantom Reads |
|------------------|-------------|-----------------------|----------------|
| READ UNCOMMITTED | ✅ Yes      | ✅ Yes                | ✅ Yes         |
| READ COMMITTED   | ❌ No       | ✅ Yes                | ✅ Yes         |
| REPEATABLE READ  | ❌ No       | ❌ No                 | ✅ Yes         |
| SERIALIZABLE     | ❌ No       | ❌ No                 | ❌ No          |

**How Enforced:**
- Through **locking**, **MVCC**, or **serialization**
- Higher levels add stricter controls, reducing concurrency

---

## 6. Read Anomalies

### 🔹 Dirty Read
Transaction A reads data modified by B, which hasn’t been committed yet.

### 🔹 Non-Repeatable Read
Transaction A reads the same row twice. B updates it in between — A sees different values.

### 🔹 Phantom Read
Transaction A runs a `SELECT` with some condition. B inserts new rows matching that condition — A sees more rows in second run.

## 13. Optimistic vs Pessimistic Concurrency

- **Optimistic**: Assume no conflict, check before commit.
- **Pessimistic**: Lock data during transaction.

## 14. Views vs Materialized Views

- **View**: Virtual, updated live.
- **Materialized View**: Stored, can be refreshed manually.

## 15. DELETE vs TRUNCATE vs DROP

- **DELETE**: Row-by-row, can rollback.
- **TRUNCATE**: Fast, resets auto-increment, cannot rollback (usually).
- **DROP**: Removes table structure.

## 17. INNER JOIN vs EXISTS

- **INNER JOIN**: Matches based on condition.
- **EXISTS**: Faster when subquery is selective.

## 18. Indexing on JSON

- JSON columns can be indexed with expression indexes (MySQL 8+).

```sql
CREATE INDEX idx_json_field ON table ((JSON_EXTRACT(data, '$.field')));
```

## 19. Query Optimization

- Use `EXPLAIN` to analyze execution plan.
- Avoid `SELECT *`.
- Index columns used in WHERE, JOIN, ORDER BY.

## 20. Auto-increment + Concurrency

- Handled via locks or internal counters.
- Can create gaps if transaction rolls back.

## 21. Triggers & Stored Procedures

- **Trigger**: Executes automatically on insert/update/delete.
- **Stored Procedure**: Reusable SQL logic, called explicitly.

## 22. Sharding / Partitioning

- **Sharding**: Split data across databases (horizontal scaling).
- **Partitioning**: Split table into segments.
  - **Horizontal**: Rows.
  - **Vertical**: Columns.