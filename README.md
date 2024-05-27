### WM Library DAO (Data Access Object) Module

purpose: access & manage data (query)

구성 항목
1. 성격에 따른 Access 방식 (JPA → repository / Mybatis → Mapper)
2. Service (데이터 처리를 보다 편리하게 진행)
3. Data Access 위한 VO (Value Object)


### Package
| 상위 패키지명            | 내용                                | 비고              |
|--------------------|-----------------------------------|-----------------|
| src/domain         | 단일 테이블에 대한 작업을 관리 (JPA)           | -               |
| src/doman/statrule | WN_STATE_RULE_INF 테이블에 대한 접근      | -               |
| src/domain/wip     | WN_WIP_STAT 테이블에 대한 접근            |                 |
| src/query          | 다중 테이블에 대한 복합 쿼리로 데이터 목적에 맞게 분류   |                 |
| src/query/carr     | Carrier에 대한 쿼리                    |                 |
| src/query/common   | WFS 일반적인 쿼리 (추후 변경 필요)            |                 |
| src/query/eqp      | 설비에 대한 쿼리                         | -               |
| src/query/lot      | Lot에 대한 쿼리                        | -               |
| src/query/sorter   | Sorter에 대한 쿼리                     | -               |
| src/query/tool     | Port & Eqp에 대한 쿼리 (추가된 항목, 변경 필요) | 추가한 내용, Eqp와 중복 |
| src/query/transfer | Transfer Job에 대한 쿼리               | -               |
| src/query/wip      | 재공 (WIP)과 관련한 쿼리                  | -               |
| src/query/work     | Work와 관련한 쿼리                      | -               |



### Mapper 정리 문서 (Excel)
https://1drv.ms/x/s!AgRrV5zybeW6iIJDTAK9CE70f2dRYw?e=Jd8Iy9