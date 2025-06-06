PGDMP      	                }            examen    17.4 (Debian 17.4-1.pgdg120+2)    17.2 %    M           0    0    ENCODING    ENCODING        SET client_encoding = 'UTF8';
                           false            N           0    0 
   STDSTRINGS 
   STDSTRINGS     (   SET standard_conforming_strings = 'on';
                           false            O           0    0 
   SEARCHPATH 
   SEARCHPATH     8   SELECT pg_catalog.set_config('search_path', '', false);
                           false            P           1262    41063    examen    DATABASE     q   CREATE DATABASE examen WITH TEMPLATE = template0 ENCODING = 'UTF8' LOCALE_PROVIDER = libc LOCALE = 'en_US.utf8';
    DROP DATABASE examen;
                     postgres    false            �            1259    41072 
   asignatura    TABLE     ~   CREATE TABLE public.asignatura (
    id integer NOT NULL,
    nombre character varying(100) NOT NULL,
    descripcion text
);
    DROP TABLE public.asignatura;
       public         heap r       postgres    false            �            1259    41071    asignatura_id_seq    SEQUENCE     �   CREATE SEQUENCE public.asignatura_id_seq
    AS integer
    START WITH 1
    INCREMENT BY 1
    NO MINVALUE
    NO MAXVALUE
    CACHE 1;
 (   DROP SEQUENCE public.asignatura_id_seq;
       public               postgres    false    219            Q           0    0    asignatura_id_seq    SEQUENCE OWNED BY     G   ALTER SEQUENCE public.asignatura_id_seq OWNED BY public.asignatura.id;
          public               postgres    false    218            �            1259    41081    curso    TABLE     �   CREATE TABLE public.curso (
    id integer NOT NULL,
    nombre character varying(100) NOT NULL,
    descripcion text,
    profesor_dni character varying(20),
    asignatura_id integer
);
    DROP TABLE public.curso;
       public         heap r       postgres    false            �            1259    41080    curso_id_seq    SEQUENCE     �   CREATE SEQUENCE public.curso_id_seq
    AS integer
    START WITH 1
    INCREMENT BY 1
    NO MINVALUE
    NO MAXVALUE
    CACHE 1;
 #   DROP SEQUENCE public.curso_id_seq;
       public               postgres    false    221            R           0    0    curso_id_seq    SEQUENCE OWNED BY     =   ALTER SEQUENCE public.curso_id_seq OWNED BY public.curso.id;
          public               postgres    false    220            �            1259    41099 
   estudiante    TABLE     �   CREATE TABLE public.estudiante (
    dni character varying(20) NOT NULL,
    nombre character varying(100) NOT NULL,
    apellido character varying(100) NOT NULL,
    email character varying(100) NOT NULL,
    fechanacimiento date
);
    DROP TABLE public.estudiante;
       public         heap r       postgres    false            �            1259    41107 	   matricula    TABLE     �   CREATE TABLE public.matricula (
    matricula_id integer NOT NULL,
    estudiante_dni character varying(20),
    curso_id integer,
    fechainscripcion date DEFAULT CURRENT_DATE
);
    DROP TABLE public.matricula;
       public         heap r       postgres    false            �            1259    41106    matricula_matricula_id_seq    SEQUENCE     �   CREATE SEQUENCE public.matricula_matricula_id_seq
    AS integer
    START WITH 1
    INCREMENT BY 1
    NO MINVALUE
    NO MAXVALUE
    CACHE 1;
 1   DROP SEQUENCE public.matricula_matricula_id_seq;
       public               postgres    false    224            S           0    0    matricula_matricula_id_seq    SEQUENCE OWNED BY     Y   ALTER SEQUENCE public.matricula_matricula_id_seq OWNED BY public.matricula.matricula_id;
          public               postgres    false    223            �            1259    41064    profesor    TABLE     �   CREATE TABLE public.profesor (
    dni character varying(20) NOT NULL,
    nombre character varying(100) NOT NULL,
    apellido character varying(100) NOT NULL,
    email character varying(100) NOT NULL
);
    DROP TABLE public.profesor;
       public         heap r       postgres    false            �           2604    41075    asignatura id    DEFAULT     n   ALTER TABLE ONLY public.asignatura ALTER COLUMN id SET DEFAULT nextval('public.asignatura_id_seq'::regclass);
 <   ALTER TABLE public.asignatura ALTER COLUMN id DROP DEFAULT;
       public               postgres    false    219    218    219            �           2604    41084    curso id    DEFAULT     d   ALTER TABLE ONLY public.curso ALTER COLUMN id SET DEFAULT nextval('public.curso_id_seq'::regclass);
 7   ALTER TABLE public.curso ALTER COLUMN id DROP DEFAULT;
       public               postgres    false    220    221    221            �           2604    41110    matricula matricula_id    DEFAULT     �   ALTER TABLE ONLY public.matricula ALTER COLUMN matricula_id SET DEFAULT nextval('public.matricula_matricula_id_seq'::regclass);
 E   ALTER TABLE public.matricula ALTER COLUMN matricula_id DROP DEFAULT;
       public               postgres    false    223    224    224            E          0    41072 
   asignatura 
   TABLE DATA           =   COPY public.asignatura (id, nombre, descripcion) FROM stdin;
    public               postgres    false    219   �*       G          0    41081    curso 
   TABLE DATA           U   COPY public.curso (id, nombre, descripcion, profesor_dni, asignatura_id) FROM stdin;
    public               postgres    false    221   �*       H          0    41099 
   estudiante 
   TABLE DATA           S   COPY public.estudiante (dni, nombre, apellido, email, fechanacimiento) FROM stdin;
    public               postgres    false    222   +       J          0    41107 	   matricula 
   TABLE DATA           ]   COPY public.matricula (matricula_id, estudiante_dni, curso_id, fechainscripcion) FROM stdin;
    public               postgres    false    224   6+       C          0    41064    profesor 
   TABLE DATA           @   COPY public.profesor (dni, nombre, apellido, email) FROM stdin;
    public               postgres    false    217   S+       T           0    0    asignatura_id_seq    SEQUENCE SET     @   SELECT pg_catalog.setval('public.asignatura_id_seq', 1, false);
          public               postgres    false    218            U           0    0    curso_id_seq    SEQUENCE SET     ;   SELECT pg_catalog.setval('public.curso_id_seq', 1, false);
          public               postgres    false    220            V           0    0    matricula_matricula_id_seq    SEQUENCE SET     I   SELECT pg_catalog.setval('public.matricula_matricula_id_seq', 1, false);
          public               postgres    false    223            �           2606    41079    asignatura asignatura_pkey 
   CONSTRAINT     X   ALTER TABLE ONLY public.asignatura
    ADD CONSTRAINT asignatura_pkey PRIMARY KEY (id);
 D   ALTER TABLE ONLY public.asignatura DROP CONSTRAINT asignatura_pkey;
       public                 postgres    false    219            �           2606    41088    curso curso_pkey 
   CONSTRAINT     N   ALTER TABLE ONLY public.curso
    ADD CONSTRAINT curso_pkey PRIMARY KEY (id);
 :   ALTER TABLE ONLY public.curso DROP CONSTRAINT curso_pkey;
       public                 postgres    false    221            �           2606    41105    estudiante estudiante_email_key 
   CONSTRAINT     [   ALTER TABLE ONLY public.estudiante
    ADD CONSTRAINT estudiante_email_key UNIQUE (email);
 I   ALTER TABLE ONLY public.estudiante DROP CONSTRAINT estudiante_email_key;
       public                 postgres    false    222            �           2606    41103    estudiante estudiante_pkey 
   CONSTRAINT     Y   ALTER TABLE ONLY public.estudiante
    ADD CONSTRAINT estudiante_pkey PRIMARY KEY (dni);
 D   ALTER TABLE ONLY public.estudiante DROP CONSTRAINT estudiante_pkey;
       public                 postgres    false    222            �           2606    41113    matricula matricula_pkey 
   CONSTRAINT     `   ALTER TABLE ONLY public.matricula
    ADD CONSTRAINT matricula_pkey PRIMARY KEY (matricula_id);
 B   ALTER TABLE ONLY public.matricula DROP CONSTRAINT matricula_pkey;
       public                 postgres    false    224            �           2606    41070    profesor profesor_email_key 
   CONSTRAINT     W   ALTER TABLE ONLY public.profesor
    ADD CONSTRAINT profesor_email_key UNIQUE (email);
 E   ALTER TABLE ONLY public.profesor DROP CONSTRAINT profesor_email_key;
       public                 postgres    false    217            �           2606    41068    profesor profesor_pkey 
   CONSTRAINT     U   ALTER TABLE ONLY public.profesor
    ADD CONSTRAINT profesor_pkey PRIMARY KEY (dni);
 @   ALTER TABLE ONLY public.profesor DROP CONSTRAINT profesor_pkey;
       public                 postgres    false    217            �           2606    41094    curso curso_asignatura_id_fkey    FK CONSTRAINT     �   ALTER TABLE ONLY public.curso
    ADD CONSTRAINT curso_asignatura_id_fkey FOREIGN KEY (asignatura_id) REFERENCES public.asignatura(id);
 H   ALTER TABLE ONLY public.curso DROP CONSTRAINT curso_asignatura_id_fkey;
       public               postgres    false    3237    221    219            �           2606    41089    curso curso_profesor_dni_fkey    FK CONSTRAINT     �   ALTER TABLE ONLY public.curso
    ADD CONSTRAINT curso_profesor_dni_fkey FOREIGN KEY (profesor_dni) REFERENCES public.profesor(dni);
 G   ALTER TABLE ONLY public.curso DROP CONSTRAINT curso_profesor_dni_fkey;
       public               postgres    false    221    217    3235            �           2606    41119 !   matricula matricula_curso_id_fkey    FK CONSTRAINT     �   ALTER TABLE ONLY public.matricula
    ADD CONSTRAINT matricula_curso_id_fkey FOREIGN KEY (curso_id) REFERENCES public.curso(id);
 K   ALTER TABLE ONLY public.matricula DROP CONSTRAINT matricula_curso_id_fkey;
       public               postgres    false    224    221    3239            �           2606    41114 '   matricula matricula_estudiante_dni_fkey    FK CONSTRAINT     �   ALTER TABLE ONLY public.matricula
    ADD CONSTRAINT matricula_estudiante_dni_fkey FOREIGN KEY (estudiante_dni) REFERENCES public.estudiante(dni);
 Q   ALTER TABLE ONLY public.matricula DROP CONSTRAINT matricula_estudiante_dni_fkey;
       public               postgres    false    224    222    3243            E      x������ � �      G      x������ � �      H      x������ � �      J      x������ � �      C      x������ � �     