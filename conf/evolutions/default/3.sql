# --- !Ups
SET @userID = UUID();

INSERT INTO user (userID, firstName, lastName, fullName, email, role) VALUES (@userID, 'Admin', 'Account', 'Admin Account', 'admin@hipcms.com', 'Admin');
INSERT INTO logininfo (providerID, providerKey) VALUES ('credentials', 'admin@hipcms.com');
INSERT INTO userlogininfo (userID, loginInfoId) VALUES (@userID, (SELECT id FROM logininfo where providerKey = 'admin@hipcms.com'));
INSERT INTO passwordinfo (hasher, password, loginInfoId) VALUES ('bcrypt', '$2a$10$dftm0sa2QgkquTolqc9.OOqN9/pdoXUjQZg16DvQ.pL29A4wF.6la', (SELECT id FROM logininfo where providerKey = 'admin@hipcms.com'));

# --- !Downs
