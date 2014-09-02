CREATE TABLE visitor
(
  visitor_id        integer     UNIQUE NOT NULL
, visitor_name1     varchar(32) 
, visitor_name2     varchar(32) 
, visitor_name1ka   varchar(32) 
, visitor_name2ka   varchar(32) 
, visitor_lccode    varchar(8)  NOT NULL
, PRIMARY KEY
  (
    visitor_id
  )
);

CREATE TABLE mailhistory
(
  mailhistory_id    integer     NOT NULL
, visitor_id        integer     NOT NULL
, title             varchar(64) 
, opendate_first    TIMESTAMP 
);

CREATE TABLE trackinghistory
(
  trackinghistory_id    integer     NOT NULL
, visitor_id            integer     NOT NULL
, title             varchar(64) 
, create_date       TIMESTAMP 
);

-- stored procedures
CREATE PROCEDURE FROM CLASS com.kzhirata.volt.procedure.VisitorMailHistory;
CREATE PROCEDURE FROM CLASS com.kzhirata.volt.procedure.VisitorTrackingHistory;

PARTITION TABLE visitor ON COLUMN visitor_id;
PARTITION TABLE mailhistory ON COLUMN visitor_id;
PARTITION TABLE trackinghistory ON COLUMN visitor_id;

CREATE INDEX v_id        ON visitor (visitor_id);
CREATE INDEX mv_id       ON mailhistory (visitor_id);
CREATE INDEX tv_id       ON trackinghistory (visitor_id);
