-- MESADM.WN_NEARBY_STK definition

CREATE TABLE "MESADM"."WN_NEARBY_STK"
(	"OBJ_ID" VARCHAR2(100),
     "SITE_ID" VARCHAR2(40),
     "EQP_ID" VARCHAR2(40),
     "ZONE_ID" VARCHAR2(40),
     "PORT_ID" VARCHAR2(40),
     "NRBY_EQP_ID" VARCHAR2(40),
     "NRBY_ZONE_ID" VARCHAR2(40),
     "SEQ" NUMBER(20,0),
     "CARR_TYP" VARCHAR2(40),
     "MDFY_USER_ID" VARCHAR2(40),
     "MDFY_DT" TIMESTAMP (6),
     "CRT_USER_ID" VARCHAR2(40),
     "CRT_DT" TIMESTAMP (6),
     "CSTM_EVNT_NM" VARCHAR2(255 CHAR),
     "EVNT_NM" VARCHAR2(255 CHAR),
     "FNL_EVNT_DT" TIMESTAMP (6),
     "PREV_CSTM_EVNT_NM" VARCHAR2(255 CHAR),
     "PREV_EVNT_NM" VARCHAR2(255 CHAR),
     "RSN_CD" VARCHAR2(255 CHAR),
     "TID" VARCHAR2(255 CHAR),
     "TRNS_CM" VARCHAR2(255 CHAR),
     "USE_STAT_CD" VARCHAR2(255 CHAR),
     CONSTRAINT "PK_WN_NEARBY_STK" PRIMARY KEY ("OBJ_ID")
         USING INDEX PCTFREE 10 INITRANS 2 MAXTRANS 255 COMPUTE STATISTICS
         STORAGE(INITIAL 65536 NEXT 1048576 MINEXTENTS 1 MAXEXTENTS 2147483645
         PCTINCREASE 0 FREELISTS 1 FREELIST GROUPS 1
         BUFFER_POOL DEFAULT FLASH_CACHE DEFAULT CELL_FLASH_CACHE DEFAULT)
         TABLESPACE "TS_MES_IDX"  ENABLE
) SEGMENT CREATION IMMEDIATE
  PCTFREE 10 PCTUSED 40 INITRANS 1 MAXTRANS 255
 NOCOMPRESS LOGGING
  STORAGE(INITIAL 65536 NEXT 1048576 MINEXTENTS 1 MAXEXTENTS 2147483645
  PCTINCREASE 0 FREELISTS 1 FREELIST GROUPS 1
  BUFFER_POOL DEFAULT FLASH_CACHE DEFAULT CELL_FLASH_CACHE DEFAULT)
  TABLESPACE "TS_MES_DAT" ;

CREATE UNIQUE INDEX "MESADM"."PK_WN_NEARBY_STK" ON "MESADM"."WN_NEARBY_STK" ("OBJ_ID")
    PCTFREE 10 INITRANS 2 MAXTRANS 255 COMPUTE STATISTICS
  STORAGE(INITIAL 65536 NEXT 1048576 MINEXTENTS 1 MAXEXTENTS 2147483645
  PCTINCREASE 0 FREELISTS 1 FREELIST GROUPS 1
  BUFFER_POOL DEFAULT FLASH_CACHE DEFAULT CELL_FLASH_CACHE DEFAULT)
  TABLESPACE "TS_MES_IDX" ;
CREATE UNIQUE INDEX "MESADM"."UK_WN_NEARBY_STK" ON "MESADM"."WN_NEARBY_STK" ("SITE_ID", "EQP_ID", "ZONE_ID", "PORT_ID", "NRBY_ZONE_ID")
    PCTFREE 10 INITRANS 2 MAXTRANS 255 COMPUTE STATISTICS
  STORAGE(INITIAL 65536 NEXT 1048576 MINEXTENTS 1 MAXEXTENTS 2147483645
  PCTINCREASE 0 FREELISTS 1 FREELIST GROUPS 1
  BUFFER_POOL DEFAULT FLASH_CACHE DEFAULT CELL_FLASH_CACHE DEFAULT)
  TABLESPACE "TS_MES_IDX" ;

COMMENT ON TABLE MESADM.WN_NEARBY_STK IS '반송을 위한 Zone 구획한 테이블';
COMMENT ON COLUMN MESADM.WN_NEARBY_STK.OBJ_ID IS '오브젝트ID';
COMMENT ON COLUMN MESADM.WN_NEARBY_STK.SITE_ID IS '사이트 정보';
COMMENT ON COLUMN MESADM.WN_NEARBY_STK.EQP_ID IS 'Equipment ID';
COMMENT ON COLUMN MESADM.WN_NEARBY_STK.ZONE_ID IS 'ZONE ID';
COMMENT ON COLUMN MESADM.WN_NEARBY_STK.PORT_ID IS '포트 ID';
COMMENT ON COLUMN MESADM.WN_NEARBY_STK.NRBY_EQP_ID IS 'Nearby EQP ID';
COMMENT ON COLUMN MESADM.WN_NEARBY_STK.NRBY_ZONE_ID IS 'Nearby ZONE ID';
COMMENT ON COLUMN MESADM.WN_NEARBY_STK.SEQ IS '순번';
COMMENT ON COLUMN MESADM.WN_NEARBY_STK.CARR_TYP IS 'Carrier 타입';
COMMENT ON COLUMN MESADM.WN_NEARBY_STK.MDFY_USER_ID IS '수정자';
COMMENT ON COLUMN MESADM.WN_NEARBY_STK.MDFY_DT IS '수정일';
COMMENT ON COLUMN MESADM.WN_NEARBY_STK.CRT_USER_ID IS '생성자';
COMMENT ON COLUMN MESADM.WN_NEARBY_STK.CRT_DT IS '생성일';
COMMENT ON COLUMN MESADM.WN_NEARBY_STK.CSTM_EVNT_NM IS '커스텀이벤트명';
COMMENT ON COLUMN MESADM.WN_NEARBY_STK.EVNT_NM IS '이벤트명';
COMMENT ON COLUMN MESADM.WN_NEARBY_STK.FNL_EVNT_DT IS '최종이벤트일시';
COMMENT ON COLUMN MESADM.WN_NEARBY_STK.PREV_CSTM_EVNT_NM IS '이전커스텀이벤트명';
COMMENT ON COLUMN MESADM.WN_NEARBY_STK.PREV_EVNT_NM IS '이전이벤트명';
COMMENT ON COLUMN MESADM.WN_NEARBY_STK.RSN_CD IS '사유코드';
COMMENT ON COLUMN MESADM.WN_NEARBY_STK.TID IS '트랜잭션ID';
COMMENT ON COLUMN MESADM.WN_NEARBY_STK.TRNS_CM IS 'Event Comment';
COMMENT ON COLUMN MESADM.WN_NEARBY_STK.USE_STAT_CD IS '사용여부';