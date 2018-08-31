DROP SCHEMA `movie_theater`;
-- -----------------------------------------------------
-- Schema movie_theater
-- -----------------------------------------------------
CREATE SCHEMA IF NOT EXISTS `movie_theater` DEFAULT CHARACTER SET utf8 ;
USE `movie_theater` ;

-- -----------------------------------------------------
-- Table `movie_theater`.`user`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `movie_theater`.`user` (
  `user_id` INT NOT NULL AUTO_INCREMENT,
  `username` VARCHAR(50) NOT NULL,
  `email` VARCHAR(255) NOT NULL,
  `password` VARCHAR(32) NOT NULL,
  `phone` VARCHAR(16) NULL,
  `role` VARCHAR(50) NOT NULL,
  PRIMARY KEY (`user_id`),
  UNIQUE INDEX `id_UNIQUE` (`user_id` ASC) VISIBLE,
  UNIQUE INDEX `username_UNIQUE` (`username` ASC) VISIBLE);


-- -----------------------------------------------------
-- Table `movie_theater`.`movie`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `movie_theater`.`movie` (
  `movie_id` INT NOT NULL AUTO_INCREMENT,
  `poster` VARCHAR(255) NOT NULL,
  `title` VARCHAR(255) NOT NULL,
  `desc` VARCHAR(255) NOT NULL,
  `length_min` INT NOT NULL,
  `trailer_code` VARCHAR(255) NOT NULL,
  `rating` INT NULL,
  PRIMARY KEY (`movie_id`),
  UNIQUE INDEX `movie_id_UNIQUE` (`movie_id` ASC) VISIBLE)
ENGINE = InnoDB
DEFAULT CHARACTER SET = utf8;


-- -----------------------------------------------------
-- Table `movie_theater`.`actor`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `movie_theater`.`actor` (
  `actor_id` INT NOT NULL AUTO_INCREMENT,
  `first_name` VARCHAR(50) NOT NULL,
  `last_name` VARCHAR(50) NOT NULL,
  `photo` VARCHAR(255) NULL COMMENT 'url to photo',
  PRIMARY KEY (`actor_id`),
  UNIQUE INDEX `actor_id_UNIQUE` (`actor_id` ASC) VISIBLE);


-- -----------------------------------------------------
-- Table `movie_theater`.`cast`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `movie_theater`.`cast` (
  `actor_id` INT NOT NULL,
  `movie_id` INT NOT NULL,
  INDEX `fk_movie_id_idx` (`movie_id` ASC) VISIBLE,
  CONSTRAINT `fk_actor_id`
    FOREIGN KEY (`actor_id`)
    REFERENCES `movie_theater`.`actor` (`actor_id`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION,
  CONSTRAINT `fk_movie_id`
    FOREIGN KEY (`movie_id`)
    REFERENCES `movie_theater`.`movie` (`movie_id`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION);


-- -----------------------------------------------------
-- Table `movie_theater`.`showtimes`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `movie_theater`.`showtimes` (
  `showtime_id` INT NOT NULL AUTO_INCREMENT,
  `movie_id` INT NOT NULL,
  `date` DATE NOT NULL,
  `start_time` DATETIME NOT NULL,
  `dayTime_show` DATETIME NOT NULL,
  UNIQUE INDEX `id_UNIQUE` (`movie_id` ASC) VISIBLE,
  PRIMARY KEY (`showtime_id`),
  UNIQUE INDEX `showtime_id_UNIQUE` (`showtime_id` ASC) VISIBLE,
  CONSTRAINT `movie_id`
    FOREIGN KEY (`movie_id`)
    REFERENCES `movie_theater`.`movie` (`movie_id`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION)
ENGINE = InnoDB
DEFAULT CHARACTER SET = utf8;


-- -----------------------------------------------------
-- Table `movie_theater`.`seat`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `movie_theater`.`seat` (
  `seat_id` INT NOT NULL,
  `row_num` INT NOT NULL,
  `seat_num` INT NOT NULL,
  PRIMARY KEY (`seat_id`),
  UNIQUE INDEX `id_UNIQUE` (`seat_id` ASC) VISIBLE,
  UNIQUE INDEX `row_num_UNIQUE` (`row_num` ASC) VISIBLE);


-- -----------------------------------------------------
-- Table `movie_theater`.`ticket`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `movie_theater`.`ticket` (
  `ticket_id` BIGINT NOT NULL,
  `seat` INT NOT NULL,
  `price` DECIMAL NOT NULL,
  `status` VARCHAR(50) NOT NULL,
  `showtime_id` INT NOT NULL,
  `user` INT NOT NULL,
  PRIMARY KEY (`ticket_id`),
  UNIQUE INDEX `id_UNIQUE` (`ticket_id` ASC) VISIBLE,
  INDEX `showtime_id_idx` (`showtime_id` ASC) VISIBLE,
  UNIQUE INDEX `showtime_id_UNIQUE` (`showtime_id` ASC) VISIBLE,
  UNIQUE INDEX `seat_UNIQUE` (`seat` ASC) VISIBLE,
  INDEX `fk_user_idx` (`user` ASC) VISIBLE,
  CONSTRAINT `fk_showtime_id`
    FOREIGN KEY (`showtime_id`)
    REFERENCES `movie_theater`.`showtimes` (`showtime_id`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION,
  CONSTRAINT `fk_seat`
    FOREIGN KEY (`seat`)
    REFERENCES `movie_theater`.`seat` (`seat_id`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION,
  CONSTRAINT `fk_user`
    FOREIGN KEY (`user`)
    REFERENCES `movie_theater`.`user` (`user_id`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION)
ENGINE = InnoDB
DEFAULT CHARACTER SET = utf8;



-- -----------------------------------------------------
-- Table `movie_theater`.`director`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `movie_theater`.`director` (
  `director_id` INT NOT NULL AUTO_INCREMENT,
  `first_name` VARCHAR(50) NOT NULL,
  `last_name` VARCHAR(50) NOT NULL,
  `photo` VARCHAR(255) NULL COMMENT 'url to photo',
  PRIMARY KEY (`director_id`),
  UNIQUE INDEX `actor_id_UNIQUE` (`director_id` ASC) VISIBLE);


-- -----------------------------------------------------
-- Table `movie_theater`.`movie_directors`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `movie_theater`.`movie_directors` (
  `director` INT NOT NULL,
  `movie_id` INT NOT NULL,
  INDEX `fk_movie_id2` (`movie_id` ASC) VISIBLE,
  INDEX `fk_director_id` (`director` ASC) VISIBLE,
  CONSTRAINT `fk_director_id`
    FOREIGN KEY (`director`)
    REFERENCES `movie_theater`.`director` (`director_id`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION,
  CONSTRAINT `fk_movie_id2`
    FOREIGN KEY (`movie_id`)
    REFERENCES `movie_theater`.`movie` (`movie_id`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION);


ALTER TABLE movie_theater.showtimes MODIFY COLUMN start_time TIME;
ALTER TABLE movie_theater.showtimes DROP COLUMN dayTime_show;
ALTER TABLE `movie_theater`.`movie` CHANGE COLUMN `desc` `description` VARCHAR(255);
<<<<<<< HEAD
ALTER TABLE movie_theater.movie DROP COLUMN rating;
ALTER TABLE movie_theater.showtimes ADD COLUMN status VARCHAR(50);
ALTER TABLE movie_theater.showtimes ADD COLUMN price DECIMAL NOT NULL;
ALTER TABLE movie_theater.ticket DROP COLUMN price;
=======
ALTER TABLE movie_theater.movie DROP COLUMN rating;
>>>>>>> e917ae97c38a952990409d57a27eb88f8c567a44
