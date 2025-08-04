create table activations(
                            id int auto_increment primary key,
                            code varchar(200),
                            active boolean,
                            desactivation datetime,
                            creation datetime default current_timestamp,
                            profile_id int,
                            constraint fk_activation_profiles foreign key (profile_id) references profiles(id)



);