

DROP TABLE IF EXISTS RECIPE CASCADE;
DROP TABLE IF EXISTS CHEF CASCADE;
DROP TABLE IF EXISTS INGREDIENT CASCADE;
DROP TABLE IF EXISTS MONTH_REF CASCADE;
DROP TABLE IF EXISTS RECIPE_INGREDIENT CASCADE;

CREATE TABLE CHEF (
   id UUID NOT NULL,
   name VARCHAR(50) NOT NULL,
   primary key(id)
);

INSERT INTO CHEF(id, name) values (
'450e8400-e29b-41d4-a716-446655440020',
'Super chef'
);

CREATE TABLE RECIPE (
   id UUID NOT NULL,
   name VARCHAR(50) NOT NULL,
   cooks_fk_id UUID NOT NULL,
   description VARCHAR NOT NULL,
   image VARCHAR NOT NULL,
   primary key(id),
   unique(name),
   CONSTRAINT FK_RECIPE_API_USER
       FOREIGN KEY (cooks_fk_id)
       REFERENCES CHEF(id)
);


CREATE TABLE MONTH_REF (
   id NUMERIC NOT NULL,
   name VARCHAR(50) NOT NULL,
   primary key(id),
   unique(name),
   unique(id)
);
INSERT INTO MONTH_REF (id, name) values (1, 'Janvier');
INSERT INTO MONTH_REF (id, name) values (2, 'Février');
INSERT INTO MONTH_REF (id, name) values (3, 'Mars');
INSERT INTO MONTH_REF (id, name) values (4, 'Avril');
INSERT INTO MONTH_REF (id, name) values (5, 'Mai');
INSERT INTO MONTH_REF (id, name) values (6, 'Juin');
INSERT INTO MONTH_REF (id, name) values (7, 'Juillet');
INSERT INTO MONTH_REF (id, name) values (8, 'Août');
INSERT INTO MONTH_REF (id, name) values (9, 'Septembre');
INSERT INTO MONTH_REF (id, name) values (10, 'Octobre');
INSERT INTO MONTH_REF (id, name) values (11, 'Novembre');
INSERT INTO MONTH_REF (id, name) values (12, 'Décembre');


CREATE TABLE INGREDIENT (
   id UUID NOT NULL,
   name VARCHAR(50) NOT NULL,
   season_start NUMERIC NOT NULL,
   season_end NUMERIC NOT NULL,
   image VARCHAR NOT NULL,
   primary key(id),
   unique(name),
   CONSTRAINT FK_FOOD_SEASON_START
       FOREIGN KEY (season_start)
       REFERENCES MONTH_REF(id),
   CONSTRAINT FK_FOOD_SEASON_END
          FOREIGN KEY (season_end)
          REFERENCES MONTH_REF(id)
);


INSERT INTO INGREDIENT (id, name, season_start, season_end, image) values (
'450e8400-e29b-41d4-a716-446655440000',
'Betterave rouge de Garonne',
9,
12,
'https://www.papillesetpupilles.fr/wp-content/uploads/2022/01/Betteraves-%C2%A9-supercat-shutterstock.jpg'
);
INSERT INTO INGREDIENT (id, name, season_start, season_end, image) values (
'450e8400-e29b-41d4-a716-446655440001',
'Blette',
9,
12,
'https://www.mangeons-local.bzh/wp-content/uploads/bette-carde.jpg'
);
INSERT INTO INGREDIENT (id, name, season_start, season_end, image) values (
'450e8400-e29b-41d4-a716-446655440002',
'Brocoli',
9,
12,
'https://resize.prod.docfr.doc-media.fr/s/1200/ext/eac4ff34/content/2022/7/5/brocoli-1000fdace663fd2b.jpeg'
);

INSERT INTO INGREDIENT (id, name, season_start, season_end, image) values (
'450e8400-e29b-41d4-a716-446655440003',
'Bolet',
9,
11,
'https://jardinage.lemonde.fr/images/dossiers/2016-10/bolet-bai-110137.jpg'
);



CREATE TABLE recipe_ingredient (
   recipe_id UUID NOT NULL,
   ingredient_id UUID NOT NULL,
      CONSTRAINT fk_recipe
             FOREIGN KEY (recipe_id)
             REFERENCES RECIPE(id),

      CONSTRAINT fk_ingredient
             FOREIGN KEY (ingredient_id)
             REFERENCES INGREDIENT(id)
);



INSERT INTO RECIPE (id, name, cooks_fk_id, description, image) values (
'450e8400-e29b-41d4-a716-446655440462',
'Gratin de brocolis facile',
'450e8400-e29b-41d4-a716-446655440020',
'ÉTAPE 1
Faire bouillir un fond d eau légèrement salée dans une grande casserole.

ÉTAPE 2
Plonger les brocolis, couvrir et laisser cuire à feu doux. Battre les 2 oeufs dans un grand bol, ajouter la crème, le sel, le poivre et la noix de muscade. Mélanger.

ÉTAPE 3
Ajouter les 2 tranches de jambon préalablement coupées en petits morceaux ainsi que le tiers du fromage râpé. Mélanger le tout.

ÉTAPE 4
Lorsque les brocolis sont tendres, les égoutter le plus possible. Préchauffer le four (180°C). Faire chauffer un fond d huile dans la casserole et y mettre l oignon haché grossièrement. Faire revenir à feu très doux et ne pas faire brunir !

ÉTAPE 5
Y ajouter les deux gousses d ail pressées et les brocolis. Assaisonner légèrement et bien mélanger.

ÉTAPE 6
Verser le contenu de la casserole dans un plat à gratin, bien étaler. Verser le mélange d oeufs, étaler le tout de façon uniforme.

ÉTAPE 7
Saupoudrer de chapelure et du restant de gruyère râpé. Mettre le plat au four, toujours sur 180°C et laisser cuire pendant entre 30 et 45 min.

ÉTAPE 8
Vérifier la cuisson de temps en temps... L ensemble doit être (en fin de cuisson) assez dense, un peu comme une grosse omelette.',

'https://assets.afcdn.com/recipe/20120824/22181_w600.jpg'
);


INSERT INTO recipe_ingredient (recipe_id, ingredient_id) values (
'450e8400-e29b-41d4-a716-446655440462',
'450e8400-e29b-41d4-a716-446655440002'
);