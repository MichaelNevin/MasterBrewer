INSERT INTO USERS (user_id , UNAME, PASS, ADMIN) VALUES 
(1, 'Michael', 'nevin', 1),
(2, 'cathy', 'password', 0),
(3, 'user', 'password', 0);

INSERT INTO PROJECT (project_id, PROJECT_OWNER_ID, PNAME, DESCRIPTION, GOAL, STATUS) VALUES 
(1, 1, 'BesterBrew', 'Imperial Stout.', 1, TRUE),
(2, 2, 'Triple D Beer', 'A better version of the initial D', 1.15, TRUE),
(3, 1, 'Nuclear Grenade', 'A strong ruby red ale', 1, TRUE),
(4, 3, 'Pillow Gun', 'Newest recipe for higher alcohol', 1, TRUE);

INSERT INTO IOTData (IOTData_id, IOTData_OWNER_ID, TARGET_ID, AMOUNT, PERMANENT) VALUES 
(1, 1, 3, 0.43, FALSE),
(2, 2, 2, .42, FALSE),
(3, 3, 1, .13, FALSE),
(4, 1, 3, .42, FALSE),
(5, 2, 2, .50, FALSE),
(6, 3, 1, .23, FALSE),
(7, 3, 4, .23, FALSE),
(8, 3, 4, .23, FALSE);