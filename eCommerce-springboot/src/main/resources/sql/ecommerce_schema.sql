DROP TABLE tb_order_item CASCADE CONSTRAINTS;
DROP TABLE tb_order CASCADE CONSTRAINTS;
DROP TABLE tb_basket_item CASCADE CONSTRAINTS;
DROP TABLE tb_basket CASCADE CONSTRAINTS;
DROP TABLE tb_category_product_mapping CASCADE CONSTRAINTS;
DROP TABLE tb_product CASCADE CONSTRAINTS;
DROP TABLE tb_category CASCADE CONSTRAINTS;
DROP TABLE tb_user CASCADE CONSTRAINTS;
DROP TABLE tb_content CASCADE CONSTRAINTS;

CREATE TABLE tb_user (
    id_user      VARCHAR2(100)   NOT NULL,
    nm_user      VARCHAR2(100)   NOT NULL,
    nm_paswd     VARCHAR2(256)   NOT NULL,
    no_mobile    VARCHAR2(30)    NOT NULL,
    nm_email     VARCHAR2(100)   NOT NULL,
    st_status    VARCHAR2(4)     NOT NULL,
    cd_user_type VARCHAR2(4)     NOT NULL,
    CONSTRAINT pk_tb_user PRIMARY KEY (id_user),
    CONSTRAINT ck_tb_user_status CHECK (st_status IN ('st01', 'st02', 'st03', 'st04')),
    CONSTRAINT uk_tb_user_email UNIQUE (nm_email),
    CONSTRAINT ck_tb_user_type CHECK (cd_user_type IN ('10', '20'))
);

CREATE TABLE tb_content (
    nb_file NUMBER(19,0) GENERATED ALWAYS AS IDENTITY NOT NULL,
    nm_org_file VARCHAR2(200),
    nm_save_file VARCHAR2(200),
    nm_file_path VARCHAR2(200),
    nm_content_type VARCHAR2(20),
    qt_file_size NUMBER(19,0),
    nm_file_ext VARCHAR2(10) NOT NULL,
    da_create_at TIMESTAMP(6) NOT NULL,
    nb_org_file NUMBER(19,0) NOT NULL,
    CONSTRAINT pk_tb_content PRIMARY KEY (nb_file),
    CONSTRAINT fk_tb_content_org FOREIGN KEY (nb_org_file) REFERENCES tb_content (nb_file)
);

CREATE TABLE tb_product (
    no_product VARCHAR2(30) NOT NULL,
    nm_product VARCHAR2(200) NOT NULL,
    nm_detail_explain VARCHAR2(4000),
    nb_file NUMBER(19,0),
    dt_start_date VARCHAR2(8) NOT NULL,
    dt_end_date VARCHAR2(8) NOT NULL,
    qt_sale_price NUMBER(9) NOT NULL,
    qt_stock NUMBER(9),
    CONSTRAINT pk_tb_product PRIMARY KEY (no_product),
    CONSTRAINT fk_tb_product_content FOREIGN KEY (nb_file) REFERENCES tb_content (nb_file)
);

CREATE TABLE tb_category (
    nb_category NUMBER(8) NOT NULL,
    nb_parent_category NUMBER(8),
    nm_category VARCHAR2(100) NOT NULL,
    cn_level NUMBER(4),
    cn_order NUMBER(4),
    CONSTRAINT pk_tb_category PRIMARY KEY (nb_category),
    CONSTRAINT fk_tb_category_parent FOREIGN KEY (nb_parent_category) REFERENCES tb_category (nb_category)
);

CREATE TABLE tb_category_product_mapping (
    nb_category NUMBER(8) NOT NULL,
    no_product VARCHAR2(30) NOT NULL,
    cn_order NUMBER(4) NOT NULL,
    CONSTRAINT pk_tb_category_product_mapping PRIMARY KEY (nb_category, no_product),
    CONSTRAINT fk_tcpm_category FOREIGN KEY (nb_category) REFERENCES tb_category (nb_category),
    CONSTRAINT fk_tcpm_product FOREIGN KEY (no_product) REFERENCES tb_product (no_product)
);

CREATE TABLE tb_basket (
    nb_basket NUMBER(9) NOT NULL,
    id_user VARCHAR2(100) NOT NULL,
    CONSTRAINT pk_tb_basket PRIMARY KEY (nb_basket),
    CONSTRAINT fk_tb_basket_user FOREIGN KEY (id_user) REFERENCES tb_user (id_user)
);

CREATE TABLE tb_order (
    id_order VARCHAR2(30) NOT NULL,
    id_user VARCHAR2(100) NOT NULL,
    qt_order_amount NUMBER(9),
    nm_order_person VARCHAR2(100),
    nm_delivery_address VARCHAR2(200),
    da_order DATE,
    st_order VARCHAR2(4),
    CONSTRAINT pk_tb_order PRIMARY KEY (id_order),
    CONSTRAINT fk_to_user FOREIGN KEY (id_user) REFERENCES tb_user (id_user),
    CONSTRAINT ck_tb_order_type CHECK (st_order IN ('10'))
);

CREATE TABLE tb_basket_item (
    nb_basket_item NUMBER(9) NOT NULL,
    nb_basket NUMBER(9) NOT NULL,
    cn_basket_item_order NUMBER(9) NOT NULL,
    no_product VARCHAR2(30) NOT NULL,
    qt_basket_item_price NUMBER(9),
    qt_basket_item NUMBER(9),
    qt_basket_item_amount NUMBER(9),
    CONSTRAINT pk_tb_basket_item PRIMARY KEY (nb_basket_item),
    CONSTRAINT fk_tb_basket_item_tb_basket FOREIGN KEY (nb_basket) REFERENCES tb_basket (nb_basket),
    CONSTRAINT fk_tb_basket_item_product FOREIGN KEY (no_product) REFERENCES tb_product (no_product)
);

CREATE TABLE tb_order_item (
    id_order_item VARCHAR2(30) NOT NULL,
    id_order VARCHAR2(30) NOT NULL,
    cn_order_item NUMBER(5) NOT NULL,
    no_product VARCHAR2(30) NOT NULL,
    qt_unit_price NUMBER(9) NOT NULL,
    qt_order_item NUMBER(9) NOT NULL,
    CONSTRAINT pk_tb_order_item PRIMARY KEY (id_order_item),
    CONSTRAINT fk_toi_order FOREIGN KEY (id_order) REFERENCES tb_order (id_order),
    CONSTRAINT fk_toi_product FOREIGN KEY (no_product) REFERENCES tb_product (no_product)
);

COMMIT;