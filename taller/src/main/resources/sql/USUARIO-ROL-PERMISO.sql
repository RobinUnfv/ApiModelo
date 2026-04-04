-- ============================================================
-- SECUENCIAS
-- ============================================================
CREATE SEQUENCE seq_roles
    START WITH 1
    INCREMENT BY 1
    NOCACHE
    NOCYCLE;

CREATE SEQUENCE seq_permisos
    START WITH 1
    INCREMENT BY 1
    NOCACHE
    NOCYCLE;

-- ============================================================
-- TABLAS
-- ============================================================

-- 1. TABLA: FACTU.PERMISOS
CREATE TABLE FACTU.PERMISOS (
                                cod_per NUMBER(10) NOT NULL,
                                nom_per VARCHAR2(50) NOT NULL,
                                descripcion VARCHAR2(200),
                                CONSTRAINT pk_permisos PRIMARY KEY (cod_per),
                                CONSTRAINT uq_permisos_nombre UNIQUE (nom_per)
);

-- 2. TABLA: FACTU.ROLES
CREATE TABLE FACTU.ROLES (
                             cod_rol NUMBER(10) NOT NULL,
                             nom_rol VARCHAR2(50) NOT NULL,
                             descripcion VARCHAR2(200),
                             CONSTRAINT pk_roles PRIMARY KEY (cod_rol),
                             CONSTRAINT uq_roles_nombre_rol UNIQUE (nom_rol)
);

-- 3.
-- ============================================================
-- ALTER TABLE - Agregar campos de seguridad a TAPUSU_PVEN
-- Schema: FACTU
-- Tabla : FACTU.TAPUSU_PVEN
-- PK    : no_cia VARCHAR2(2) + usuario VARCHAR2(15)
-- ============================================================

ALTER TABLE FACTU.TAPUSU_PVEN
    ADD (
        cuenta_no_expirada      NUMBER(1),
        cuenta_no_bloqueada     NUMBER(1),
        credencial_no_expirada  NUMBER(1)
    );

-- ============================================================
-- CONSTRAINTS CHECK para los nuevos campos
-- ============================================================

ALTER TABLE FACTU.TAPUSU_PVEN
    ADD CONSTRAINT chk_tapusu_cta_expirada
        CHECK (cuenta_no_expirada IN (0,1));

ALTER TABLE FACTU.TAPUSU_PVEN
    ADD CONSTRAINT chk_tapusu_cta_bloqueada
        CHECK (cuenta_no_bloqueada IN (0,1));

ALTER TABLE FACTU.TAPUSU_PVEN
    ADD CONSTRAINT chk_tapusu_cred_expirada
        CHECK (credencial_no_expirada IN (0,1));

-- ============================================================
-- COMENTARIOS de los nuevos campos
-- ============================================================

COMMENT ON COLUMN FACTU.TAPUSU_PVEN.cuenta_no_expirada IS '1=cuenta vigente, 0=cuenta expirada';
COMMENT ON COLUMN FACTU.TAPUSU_PVEN.cuenta_no_bloqueada IS '1=cuenta activa, 0=cuenta bloqueada';
COMMENT ON COLUMN FACTU.TAPUSU_PVEN.credencial_no_expirada IS '1=credencial vigente, 0=credencial expirada';

-- 4. TABLA: FACTU.ROLES_PERMISOS (tabla intermedia M:M)
CREATE TABLE FACTU.ROLES_PERMISOS (
                                      cod_rol     NUMBER(10) NOT NULL,
                                      cod_per     NUMBER(10) NOT NULL,
                                      CONSTRAINT pk_roles_permisos PRIMARY KEY (cod_rol, cod_per),
                                      CONSTRAINT fk_rp_rol         FOREIGN KEY (cod_rol) REFERENCES FACTU.ROLES (cod_rol)     ON DELETE CASCADE,
                                      CONSTRAINT fk_rp_permiso     FOREIGN KEY (cod_per) REFERENCES FACTU.PERMISOS (cod_per)  ON DELETE CASCADE
);

-- 5. TABLA: FACTU.USUARIO_ROLES (tabla intermedia M:M)
CREATE TABLE FACTU.USUARIO_ROLES (
                                     no_cia VARCHAR2(2) NOT NULL,
                                     usuario VARCHAR2(15) NOT NULL,
                                     cod_rol NUMBER(10) NOT NULL,
                                     CONSTRAINT pk_usuarios_roles PRIMARY KEY (no_cia,usuario, cod_rol)
);


-- ============================================================
-- COMENTARIOS
-- ============================================================

-- Tabla: FACTU.PERMISOS
COMMENT ON TABLE  FACTU.PERMISOS             IS 'Catálogo de permisos del sistema';
COMMENT ON COLUMN FACTU.PERMISOS.cod_per     IS 'Código secuencial único del permiso (PK)';
COMMENT ON COLUMN FACTU.PERMISOS.nom_per      IS 'Nombre único del permiso (ej: LEER, ESCRIBIR)';
COMMENT ON COLUMN FACTU.PERMISOS.descripcion IS 'Descripción detallada del permiso';

-- Tabla: FACTU.ROLES
COMMENT ON TABLE  FACTU.ROLES                IS 'Catálogo de roles del sistema';
COMMENT ON COLUMN FACTU.ROLES.cod_rol        IS 'Código secuencial único del rol (PK)';
COMMENT ON COLUMN FACTU.ROLES.nom_rol     IS 'Nombre del rol (ADMINISTRADOR, USUARIO, MODERADOR)';
COMMENT ON COLUMN FACTU.ROLES.descripcion    IS 'Descripción detallada del rol';

-- Tabla: FACTU.ROLES_PERMISOS
COMMENT ON TABLE  FACTU.ROLES_PERMISOS         IS 'Relación M:M entre FACTU.ROLES y FACTU.permisos';
COMMENT ON COLUMN FACTU.ROLES_PERMISOS.cod_rol IS 'FK hacia la tabla roles';
COMMENT ON COLUMN FACTU.ROLES_PERMISOS.cod_per IS 'FK hacia la tabla permisos';

-- Tabla: FACTU.USUARIO_ROLES
COMMENT ON TABLE  FACTU.USUARIO_ROLES         IS 'Relación M:M entre FACTU.TAPUSU_PVEN y FACTU.ROLES';
COMMENT ON COLUMN FACTU.USUARIO_ROLES.no_cia  IS 'FK hacia la tabla FACTU.TAPUSU_PVEN';
COMMENT ON COLUMN FACTU.USUARIO_ROLES.usuario IS 'FK hacia la tabla FACTU.TAPUSU_PVEN';
COMMENT ON COLUMN FACTU.USUARIO_ROLES.cod_rol IS 'FK hacia la tabla roles';

INSERT INTO FACTU.PERMISOS VALUES( seq_permisos.nextval, 'READ', 'PERMISO DE LECTURA' );
INSERT INTO FACTU.PERMISOS VALUES( seq_permisos.nextval, 'CREATE', 'PERMISO PARA CREAR' );
INSERT INTO FACTU.PERMISOS VALUES( seq_permisos.nextval, 'DELETE', 'PERMISO PARA ELIMINAR' );
INSERT INTO FACTU.PERMISOS VALUES( seq_permisos.nextval, 'UPDATE', 'PERMISO PARA ACTUALIZAR' );

INSERT INTO FACTU.ROLES VALUES( seq_roles.nextval, 'ADMIN', 'ADMINISTRADOR' );
INSERT INTO FACTU.ROLES VALUES( seq_roles.nextval, 'CUSTOMER', 'CLIENTE' );-- ROLES_PERMISOS

INSERT INTO FACTU.ROLES_PERMISOS VALUES( 1, 1 );
INSERT INTO FACTU.ROLES_PERMISOS VALUES( 1, 2 );
INSERT INTO FACTU.ROLES_PERMISOS VALUES( 1, 3 );
INSERT INTO FACTU.ROLES_PERMISOS VALUES( 1, 4 );
INSERT INTO FACTU.ROLES_PERMISOS VALUES( 2, 1 );

INSERT INTO FACTU.USUARIO_ROLES VALUES( '01', 'LLE', 1 );
INSERT INTO FACTU.USUARIO_ROLES VALUES( '01', 'YPC', 2 );