-- MESADM.WN_TRANSFER_JOB definition

CREATE TABLE "MESADM"."WN_TRANSFER_JOB"
(	"OBJ_ID" VARCHAR2(100),
     "SITE_ID" VARCHAR2(40),
     "JOB_ID" VARCHAR2(64),
     "CARR_ID" VARCHAR2(40),
     "CRNT_EQP_ID" VARCHAR2(64),
     "CRNT_PORT_ID" VARCHAR2(40),
     "SRC_EQP_ID" VARCHAR2(64),
     "SRC_PORT_ID" VARCHAR2(40),
     "DEST_EQP_ID" VARCHAR2(64),
     "DEST_PORT_ID" VARCHAR2(40),
     "MOVE_STAT_CD" VARCHAR2(40),
     "PRIRT_NO" VARCHAR2(40),
     "FNL_EVNT_NM" VARCHAR2(40),
     "FNL_EVNT_DT" TIMESTAMP (6),
     "MDFY_USER_ID" VARCHAR2(40),
     "MDFY_DT" TIMESTAMP (6),
     "CRT_USER_ID" VARCHAR2(40),
     "CRT_DT" TIMESTAMP (6),
     "CSTM_EVNT_NM" VARCHAR2(255 CHAR),
     "EVNT_NM" VARCHAR2(255 CHAR),
     "PREV_CSTM_EVNT_NM" VARCHAR2(255 CHAR),
     "PREV_EVNT_NM" VARCHAR2(255 CHAR),
     "RSN_CD" VARCHAR2(255 CHAR),
     "TID" VARCHAR2(255 CHAR),
     "TRNS_CM" VARCHAR2(255 CHAR),
     "USE_STAT_CD" VARCHAR2(255 CHAR),
     CONSTRAINT "PK_WN_TRANSFER_JOB" PRIMARY KEY ("OBJ_ID")
);

COMMENT ON COLUMN MESADM.WN_TRANSFER_JOB.OBJ_ID IS '오브젝트ID';
COMMENT ON COLUMN MESADM.WN_TRANSFER_JOB.SITE_ID IS '사이트 정보';
COMMENT ON COLUMN MESADM.WN_TRANSFER_JOB.JOB_ID IS 'Job ID';
COMMENT ON COLUMN MESADM.WN_TRANSFER_JOB.CARR_ID IS 'Carrier Id';
COMMENT ON COLUMN MESADM.WN_TRANSFER_JOB.CRNT_EQP_ID IS '현재 Eqp Id';
COMMENT ON COLUMN MESADM.WN_TRANSFER_JOB.CRNT_PORT_ID IS '현재 Port Id';
COMMENT ON COLUMN MESADM.WN_TRANSFER_JOB.SRC_EQP_ID IS '출발지 Eqp Id';
COMMENT ON COLUMN MESADM.WN_TRANSFER_JOB.SRC_PORT_ID IS '출발지 Port Id';
COMMENT ON COLUMN MESADM.WN_TRANSFER_JOB.DEST_EQP_ID IS '목적지 Eqp Id';
COMMENT ON COLUMN MESADM.WN_TRANSFER_JOB.DEST_PORT_ID IS '목적지 Port Id';
COMMENT ON COLUMN MESADM.WN_TRANSFER_JOB.MOVE_STAT_CD IS '반송상태';
COMMENT ON COLUMN MESADM.WN_TRANSFER_JOB.PRIRT_NO IS '우선순위번호';
COMMENT ON COLUMN MESADM.WN_TRANSFER_JOB.FNL_EVNT_NM IS '최종이벤트명';
COMMENT ON COLUMN MESADM.WN_TRANSFER_JOB.FNL_EVNT_DT IS '최종이벤트일시';
COMMENT ON COLUMN MESADM.WN_TRANSFER_JOB.MDFY_USER_ID IS '수정자';
COMMENT ON COLUMN MESADM.WN_TRANSFER_JOB.MDFY_DT IS '수정일';
COMMENT ON COLUMN MESADM.WN_TRANSFER_JOB.CRT_USER_ID IS '생성자';
COMMENT ON COLUMN MESADM.WN_TRANSFER_JOB.CRT_DT IS '생성일';