ALTER TABLE keycloak.user_entity
    ADD thesis_id integer;

ALTER TABLE keycloak.user_entity
    ADD FOREIGN KEY (thesis_id) REFERENCES swsdatabase.thesis(id);