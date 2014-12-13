-- phpMyAdmin SQL Dump
-- version 3.4.10.1deb1
-- http://www.phpmyadmin.net
--
-- Host: localhost
-- Generation Time: Dec 13, 2014 at 10:30 PM
-- Server version: 5.5.40
-- PHP Version: 5.4.34-1+deb.sury.org~precise+1

SET SQL_MODE="NO_AUTO_VALUE_ON_ZERO";
SET time_zone = "+00:00";


/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
/*!40101 SET NAMES utf8 */;

--
-- Database: `doctors_community`
--

-- --------------------------------------------------------

--
-- Table structure for table `category`
--

CREATE TABLE IF NOT EXISTS `category` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `name` varchar(100) NOT NULL,
  `detail` varchar(255) NOT NULL,
  `parent_id` int(11) NOT NULL,
  `created_at` int(11) NOT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB  DEFAULT CHARSET=utf8 AUTO_INCREMENT=18 ;

--
-- Dumping data for table `category`
--

INSERT INTO `category` (`id`, `name`, `detail`, `parent_id`, `created_at`) VALUES
(2, 'Acupunture', '', 2, 2147483647),
(4, 'Anatomy', '', 0, 1417581034),
(5, 'Biochemistry', '', 0, 1417581054),
(6, 'Cardiology', '', 0, 1418392344),
(7, 'Chest diseases ', '', 0, 1418392373),
(8, 'Child', '', 0, 1418392408),
(9, 'Clinical hematology ', '', 0, 1418392428),
(10, 'Dental', '', 0, 1418392440),
(11, 'Diabetology', '', 0, 1418392456),
(12, 'General surgery', '', 0, 1418392522),
(13, 'Haematology', '', 0, 1418392541),
(14, 'Herbal', '', 0, 1418392553),
(15, 'Medicine', '', 0, 1418392569),
(16, 'Neurosurgeon', '', 0, 1418392614),
(17, 'Orthopaedics', '', 0, 1418392649);

-- --------------------------------------------------------

--
-- Table structure for table `category_content_relation`
--

CREATE TABLE IF NOT EXISTS `category_content_relation` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `category_id` int(11) NOT NULL,
  `content_id` int(11) NOT NULL,
  PRIMARY KEY (`id`),
  KEY `category_id_idx` (`category_id`),
  KEY `content_id_idx` (`content_id`)
) ENGINE=InnoDB  DEFAULT CHARSET=utf8 AUTO_INCREMENT=53 ;

--
-- Dumping data for table `category_content_relation`
--

INSERT INTO `category_content_relation` (`id`, `category_id`, `content_id`) VALUES
(1, 6, 11),
(2, 2, 9),
(3, 2, 10),
(4, 0, 12),
(5, 4, 13),
(6, 2, 14),
(7, 3, 15),
(8, 4, 16),
(9, 2, 17),
(10, 2, 18),
(11, 3, 19),
(12, 0, 19),
(13, 0, 20),
(14, 0, 21),
(15, 0, 22),
(16, 0, 23),
(17, 0, 24),
(18, 0, 25),
(19, 0, 25),
(20, 2, 9),
(21, 4, 28),
(22, 2, 29),
(23, 4, 30),
(24, 5, 31),
(25, 4, 32),
(26, 2, 32),
(27, 4, 32),
(28, 6, 33),
(29, 2, 0),
(30, 2, 0),
(31, 0, 0),
(32, 2, 0),
(33, 2, 0),
(34, 4, 0),
(35, 2, 34),
(36, 0, 35),
(37, 0, 36),
(38, 0, 37),
(39, 0, 38),
(40, 0, 39),
(41, 0, 40),
(42, 0, 41),
(43, 0, 42),
(44, 0, 43),
(45, 0, 44),
(46, 0, 45),
(47, 0, 46),
(48, 0, 47),
(49, 0, 48),
(50, 5, 49),
(51, 5, 50),
(52, 6, 51);

-- --------------------------------------------------------

--
-- Table structure for table `category_user_relation`
--

CREATE TABLE IF NOT EXISTS `category_user_relation` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `category_id` int(11) NOT NULL,
  `user_id` int(11) NOT NULL,
  PRIMARY KEY (`id`),
  KEY `category_id_idx` (`category_id`),
  KEY `user_id_idx` (`user_id`)
) ENGINE=InnoDB  DEFAULT CHARSET=utf8 AUTO_INCREMENT=13 ;

--
-- Dumping data for table `category_user_relation`
--

INSERT INTO `category_user_relation` (`id`, `category_id`, `user_id`) VALUES
(1, 2, 1),
(2, 3, 1),
(3, 4, 1),
(8, 2, 1),
(12, 5, 1);

-- --------------------------------------------------------

--
-- Table structure for table `chamber_detail`
--

CREATE TABLE IF NOT EXISTS `chamber_detail` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `user_id` int(11) NOT NULL,
  `name` varchar(100) NOT NULL,
  `address` varchar(255) NOT NULL,
  `telephone` varchar(20) NOT NULL,
  `visiting_hour` varchar(20) NOT NULL,
  `visiting_days` varchar(50) NOT NULL,
  `fees` varchar(50) NOT NULL,
  PRIMARY KEY (`id`),
  KEY `fk_chamber_detail_user1_idx` (`user_id`)
) ENGINE=InnoDB  DEFAULT CHARSET=utf8 AUTO_INCREMENT=10 ;

--
-- Dumping data for table `chamber_detail`
--

INSERT INTO `chamber_detail` (`id`, `user_id`, `name`, `address`, `telephone`, `visiting_hour`, `visiting_days`, `fees`) VALUES
(1, 1, '', 'gulshan', '123456789', '10am-12pm', 'monday', '500/='),
(8, 1, 'Chamber 02', 'Mirpur', '012345', '12-6', 'mon-friday', '200'),
(9, 1, 'Chamber 01', 'MP', '0123456', '10-5', 'Monday-Thusday', '300');

-- --------------------------------------------------------

--
-- Table structure for table `comment`
--

CREATE TABLE IF NOT EXISTS `comment` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `content_id` int(11) NOT NULL,
  `user_id` int(11) NOT NULL,
  `content` text NOT NULL,
  `parent_id` int(11) NOT NULL,
  `created_at` int(11) NOT NULL,
  PRIMARY KEY (`id`),
  KEY `post_id_idx` (`content_id`),
  KEY `user_id_idx` (`user_id`)
) ENGINE=InnoDB  DEFAULT CHARSET=utf8 AUTO_INCREMENT=28 ;

--
-- Dumping data for table `comment`
--

INSERT INTO `comment` (`id`, `content_id`, `user_id`, `content`, `parent_id`, `created_at`) VALUES
(1, 13, 1, 'first comment', 0, 1416850641),
(2, 16, 1, '1st comment on PC2', 0, 1416891056),
(3, 18, 1, '1st comment on discussion', 0, 1416902409),
(4, 18, 1, '2nd comment on Discussion', 0, 1416902429),
(5, 17, 1, 'new now ', 0, 1417072779),
(8, 20, 1, 'que 01 comment 02', 0, 1417275692),
(9, 22, 1, 'q2 c2', 0, 1417275714),
(10, 23, 1, 'q1 c1', 0, 1417276518),
(12, 23, 2, 'q1 c2', 0, 1417276582),
(13, 13, 1, 'second comment', 0, 1417353576),
(16, 23, 1, 'q1 c3', 0, 1417357596),
(17, 24, 1, 'q2 c1', 0, 1417357617),
(18, 29, 1, '1st comment on article', 0, 1417581705),
(20, 9, 1, '1st comment on 9', 0, 1418110818),
(21, 9, 1, '2nd comment on 9', 0, 1418110846),
(23, 9, 1, '3rd comment on 9', 0, 1418110902),
(25, 18, 1, '3rd comment on discussion', 0, 1418111196),
(27, 32, 1, 'Patient is given medicine ', 0, 1418448967);

-- --------------------------------------------------------

--
-- Table structure for table `configuration`
--

CREATE TABLE IF NOT EXISTS `configuration` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `name` varchar(255) NOT NULL,
  `value` text NOT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB  DEFAULT CHARSET=utf8 AUTO_INCREMENT=7 ;

--
-- Dumping data for table `configuration`
--

INSERT INTO `configuration` (`id`, `name`, `value`) VALUES
(3, 'uploadDir', 'uploads'),
(4, 'siteURL', 'http://localhost:7005/DoctorCommunity'),
(5, 'siteTitle', 'Doctors Community'),
(6, 'adminEmail', 'jucse2014@gmail.com');

-- --------------------------------------------------------

--
-- Table structure for table `content`
--

CREATE TABLE IF NOT EXISTS `content` (
  `id` int(11) NOT NULL,
  `user_id` int(11) NOT NULL,
  `title` varchar(255) NOT NULL,
  `description` text NOT NULL,
  `type` int(1) NOT NULL,
  `privacy` int(1) NOT NULL,
  `allow_comment` int(1) NOT NULL,
  `comment_counter` int(11) NOT NULL,
  `parent_id` int(11) NOT NULL,
  `created_at` int(11) NOT NULL,
  PRIMARY KEY (`id`),
  KEY `user_id_idx` (`user_id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

--
-- Dumping data for table `content`
--

INSERT INTO `content` (`id`, `user_id`, `title`, `description`, `type`, `privacy`, `allow_comment`, `comment_counter`, `parent_id`, `created_at`) VALUES
(11, 1, 'Heart block', 'Patient is having a heart block for last 2 months', 1, 2, 1, 0, 0, 1416829508),
(16, 1, 'Patient case 02', 'This is a simple patient case who is under the treatment for last 2 years and improving ', 2, 2, 1, 0, 0, 1416890751),
(24, 1, 'Fever problem', 'I am having fever for last few weeks and it is not totally cured. I take medicine and still it came back. What to do now? ', 4, 2, 1, 1, 0, 1417276467),
(25, 1, 'Having headach ', 'I am suffering from headach for last 2 years. Can anyone help me with any sugestion?', 4, 1, 1, 0, 0, 1417356566),
(28, 1, 'Ankel injury', 'patient has suffered form ankel injury for last 1 month and got a displaced ankel', 2, 2, 1, 0, 0, 1417541657),
(32, 1, 'Ankel injury', 'The patient displace his ankel and take serious injury. Need some suggestion for better treatment ', 1, 1, 1, 1, 0, 1417923143),
(33, 1, 'Disorders of the coronary circulation', 'Contrary to a basic understanding of the cardiovascular system, the heart cannot itself receive enough oxygen and nutrients from the blood it pumps and it must be supplied with blood as if it were any other organ in the body. Unlike the systemic organs the heart receives perfusion in the phase of diastole rather than systole. This circulation of blood is called the coronary circulation. The coronary circulation consists of coronary arteries and coronary veins.', 3, 2, 1, 0, 0, 1417938979),
(34, 1, 'Brain tips', 'something about brain', 6, 2, 0, 0, 0, 1418111376),
(35, 1, 'Sip Oolong Tea', 'Research suggests that people with mild eczema who drink oolong tea three times a day may show improvement in itching and other symptoms. Compounds in the tea called polyphenols appear to be responsible.', 6, 2, 0, 0, 0, 1418387886),
(36, 1, 'Go Herbal', 'For varicose veins, try horse chestnut, an herbal extract that''s been shown in studies to strengthen veins and reduce swelling. The herb is also available in topical creams, though there''s not as much evidence for these.', 6, 2, 0, 0, 0, 1418387968),
(37, 1, 'Enjoy Ginger', 'The volatile oils in ginger have long made it a useful herbal remedy for nasal and chest congestion. Pour 2 cups of boiling water over a 1-inch piece of peeled, grated ginger; steep for 10 minutes; and strain. Add a pinch or two of cayenne pepper to the water and drink as needed.', 6, 2, 0, 0, 0, 1418388010),
(38, 1, 'Sniff Rosemary', 'According to some research, catching a whiff of this aromatic herb may increase alertness and improve memory. To stay sharp, try smelling fresh rosemary or inhaling the scent of rosemary essential oil before a test or meeting.', 6, 2, 0, 0, 0, 1418388037),
(39, 1, 'Embrace Bitters', 'Combat a yen for sugar by following a Chinese medicine approach: Eat foods such as endive, radicchio, cooked greens, and olives.', 6, 2, 0, 0, 0, 1418388086),
(40, 1, 'Go Fish', 'If you suffer from dry eyes, up your seafood intake. Salmon, sardines, and mackerel contain omega-3 fatty acids, which the body uses to produce tears, among other things. Research suggests that people who consume higher amounts of these fats are less likely to have dry eyes.', 6, 2, 0, 0, 0, 1418388111),
(41, 1, 'Pop a Probiotic', 'To keep yeast infections at bay, head for the vitamin aisle. Supplementing with "good" bacteria (for example, Lactobacillus or Bifidobacterium) may help restore the balance the of bacteria living in the female genital tract and inhibit the growth of yeast in women with recurrent infections. Foods such as naturally fermented sauerkraut, kimchi, and kefir, as well as yogurt with active cultures, also contain these bacteria.', 6, 2, 0, 0, 0, 1418388133),
(42, 1, 'Benefit From Bilberry', 'Studies are mixed, but some have found that bilberry, a relative of the blueberry, may improve night vision. During World War II, fighter pilots reported better night vision after eating bilberry jam. Take 25 to 50 milligrams of bilberry extract; expect best results within the first few hours.', 6, 2, 0, 0, 0, 1418388152),
(43, 1, 'Eat Bananas', 'People whose diets are rich in potassium may be less prone to high blood pressure. Besides reducing sodium and taking other heart-healthy steps, eat potassium-packed picks such as bananas, cantaloupe, and oranges.', 6, 2, 0, 0, 0, 1418388172),
(44, 1, 'Go for Garlic', 'Adding raw or lightly cooked garlic and onions to your meals may help keep you healthy this winter. Both foods appear to possess antiviral and antibacterial properties and are believed to boost immunity.', 6, 2, 0, 0, 0, 1418388204),
(45, 1, 'Try Tea Tree Oil', 'For athlete''s foot, reach for tea tree oil, an extract of the leaves of an Australian tree. It appears to have antiseptic properties and may work as well as or better than over-the-counter antifungal products. Apply a light coating of the oil to affected areas two to three times a day; continue for a week or two after symptoms disappear.', 6, 2, 0, 0, 0, 1418388239),
(46, 1, 'Take Tulsi', 'Research suggests that this Ayurvedic herb, also called holy basil, may help manage levels of the stress hormone cortisol, helping to boost your mood. Look for teas and supplements in health-food stores and follow package directions.', 6, 2, 0, 0, 0, 1418388267),
(47, 1, 'Make Small Talk', 'Engaging in casual conversation with others may help keep you as sharp as doing a word puzzle, according to some studies. Just 10 minutes of daily chatter appears to improve mental function and preserve memory', 6, 2, 0, 0, 0, 1418388314),
(48, 1, 'Get Your Daily D', 'Get your vitamin D level checked with a simple blood test. D is at least as important as calcium for strong bones, and most Americans don''t get enough. Get a minimum of 1,000 IU a day through supplements and food.', 6, 2, 0, 0, 0, 1418388383),
(49, 1, 'Carbohydrates', 'The function of carbohydrates includes energy storage and providing structure. Sugars are carbohydrates, but not all carbohydrates are sugars. There are more carbohydrates on Earth than any other known type of biomolecule; they are used to store energy and genetic information, as well as play important roles in cell to cell interactions and communications.', 3, 2, 1, 0, 0, 1418450533),
(50, 1, 'Carbohydrates', 'The function of carbohydrates includes energy storage and providing structure. Sugars are carbohydrates, but not all carbohydrates are sugars. There are more carbohydrates on Earth than any other known type of biomolecule; they are used to store energy and genetic information, as well as play important roles in cell to cell interactions and communications.', 5, 2, 1, 0, 0, 1418450773),
(51, 1, 'Disorders of the coronary circulation', 'Contrary to a basic understanding of the cardiovascular system, the heart cannot itself receive enough oxygen and nutrients from the blood it pumps and it must be supplied with blood as if it were any other organ in the body. Unlike the systemic organs the heart receives perfusion in the phase of diastole rather than systole. This circulation of blood is called the coronary circulation. The coronary circulation consists of coronary arteries and coronary veins.', 5, 2, 1, 0, 0, 1418450793);

-- --------------------------------------------------------

--
-- Table structure for table `education`
--

CREATE TABLE IF NOT EXISTS `education` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `user_id` int(11) NOT NULL,
  `degree` varchar(255) NOT NULL,
  `institute` varchar(255) NOT NULL,
  `result` varchar(20) NOT NULL,
  PRIMARY KEY (`id`),
  KEY `fk_education_user1_idx` (`user_id`)
) ENGINE=InnoDB  DEFAULT CHARSET=utf8 AUTO_INCREMENT=8 ;

--
-- Dumping data for table `education`
--

INSERT INTO `education` (`id`, `user_id`, `degree`, `institute`, `result`) VALUES
(6, 1, 'SSC', 'GMHS', '5.00'),
(7, 1, 'HSC', 'Adanjee Cant. College', '5.00');

-- --------------------------------------------------------

--
-- Table structure for table `experience`
--

CREATE TABLE IF NOT EXISTS `experience` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `user_id` int(11) NOT NULL,
  `title` varchar(255) NOT NULL,
  `description` text NOT NULL,
  PRIMARY KEY (`id`),
  KEY `fk_experience_user1_idx` (`user_id`)
) ENGINE=InnoDB  DEFAULT CHARSET=utf8 AUTO_INCREMENT=3 ;

--
-- Dumping data for table `experience`
--

INSERT INTO `experience` (`id`, `user_id`, `title`, `description`) VALUES
(1, 1, 'Hospital Experience', 'i worked in hospital for 3 years and continued'),
(2, 1, 'Clinic experience', 'i worked in clinic for last 2 years');

-- --------------------------------------------------------

--
-- Table structure for table `media`
--

CREATE TABLE IF NOT EXISTS `media` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `user_id` int(11) NOT NULL,
  `content_id` int(11) NOT NULL,
  `title` varchar(255) NOT NULL,
  `filename` varchar(100) NOT NULL,
  `link` varchar(255) NOT NULL,
  `file_path` varchar(255) NOT NULL,
  `media_type` varchar(50) NOT NULL,
  `created_at` int(11) NOT NULL,
  PRIMARY KEY (`id`),
  KEY `user_id_idx` (`user_id`),
  KEY `content_id_idx` (`content_id`)
) ENGINE=InnoDB  DEFAULT CHARSET=utf8 AUTO_INCREMENT=12 ;

--
-- Dumping data for table `media`
--

INSERT INTO `media` (`id`, `user_id`, `content_id`, `title`, `filename`, `link`, `file_path`, `media_type`, `created_at`) VALUES
(1, 1, 0, 'Scanned FIles', 'eric-scan.jpg', 'http://localhost:7005/DoctorCommunity/uploads/eric-scan.jpg', '/opt/apache-tomcat-7.0.56/webapps/DoctorCommunity/uploads/eric-scan.jpg', 'image/jpeg', 1417834309),
(2, 1, 0, 'Another Scanned file', 'eric-scan.jpg', 'http://localhost:7005/DoctorCommunity/uploads/eric-scan.jpg', '/opt/apache-tomcat-7.0.56/webapps/DoctorCommunity/uploads/eric-scan.jpg', 'image/jpeg', 1417834469),
(3, 1, 0, 'Belt', 'AT75147BL__61843.jpg', 'http://localhost:7005/DoctorCommunity/uploads/AT75147BL__61843.jpg', '/opt/apache-tomcat-7.0.56/webapps/DoctorCommunity/uploads/AT75147BL__61843.jpg', 'image/jpeg', 1417837922),
(4, 1, 0, 'Big Blue', 'blue_fabric_background-wallpaper-1920x1080.jpg', 'http://localhost:7005/DoctorCommunity/uploads/blue_fabric_background-wallpaper-1920x1080.jpg', '/opt/apache-tomcat-7.0.56/webapps/DoctorCommunity/uploads/blue_fabric_background-wallpaper-1920x1080.jpg', 'image/jpeg', 1417857889),
(5, 1, 0, 'BitBook', 'bitbook.jpg', 'http://localhost:7005/DoctorCommunity/uploads/bitbook.jpg', '/opt/apache-tomcat-7.0.56/webapps/DoctorCommunity/uploads/bitbook.jpg', 'image/jpeg', 1417858304),
(6, 1, 0, 'Another Bitbook', 'bitbook.jpg', 'http://localhost:7005/DoctorCommunity/uploads/bitbook.jpg', '/opt/apache-tomcat-7.0.56/webapps/DoctorCommunity/uploads/bitbook.jpg', 'image/jpeg', 1417859629),
(7, 1, 0, 'One More Bitbook', 'bitbook.jpg', 'http://localhost:7005/DoctorCommunity/uploads/bitbook.jpg', '/opt/apache-tomcat-7.0.56/webapps/DoctorCommunity/uploads/bitbook.jpg', 'image/jpeg', 1417859640),
(8, 1, 0, 'Another Belt', 'AT75147BL__61843.jpg', 'http://localhost:7005/DoctorCommunity/uploads/AT75147BL__61843.jpg', '/opt/apache-tomcat-7.0.56/webapps/DoctorCommunity/uploads/AT75147BL__61843.jpg', 'image/jpeg', 1417859657),
(9, 1, 0, 'The LS Logo', 'lsf main-120.png', 'http://localhost:7005/DoctorCommunity/uploads/lsf main-120.png', '/opt/apache-tomcat-7.0.56/webapps/DoctorCommunity/uploads/lsf main-120.png', 'image/png', 1417864837),
(10, 1, 0, 'Green Day', 'green_background_2-wallpaper-1920x1080.jpg', 'http://localhost:7005/DoctorCommunity/uploads/green_background_2-wallpaper-1920x1080.jpg', '/opt/apache-tomcat-7.0.56/webapps/DoctorCommunity/uploads/green_background_2-wallpaper-1920x1080.jpg', 'image/jpeg', 1417864853),
(11, 1, 0, 'The Belty', 'AT75147BL__61843.jpg', 'http://localhost:7005/DoctorCommunity/uploads/AT75147BL__61843.jpg', '/opt/apache-tomcat-7.0.56/webapps/DoctorCommunity/uploads/AT75147BL__61843.jpg', 'image/jpeg', 1417872464);

-- --------------------------------------------------------

--
-- Table structure for table `message`
--

CREATE TABLE IF NOT EXISTS `message` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `from_user_id` int(11) NOT NULL,
  `to_user_id` int(11) NOT NULL,
  `msg` text NOT NULL,
  `created_at` int(11) NOT NULL,
  PRIMARY KEY (`id`),
  KEY `from_user_id_idx` (`from_user_id`),
  KEY `to_user_id_idx` (`to_user_id`)
) ENGINE=InnoDB  DEFAULT CHARSET=utf8 AUTO_INCREMENT=213 ;

--
-- Dumping data for table `message`
--

INSERT INTO `message` (`id`, `from_user_id`, `to_user_id`, `msg`, `created_at`) VALUES
(3, 2, 1, 'hi lenin', 1416441262),
(4, 3, 1, 'hello there', 1416441264),
(5, 2, 1, 'yoo lenin', 1416441269),
(6, 5, 12, 'Magnam aut sed voluptas beatae autem iusto similique.', 855400036),
(7, 2, 11, 'Incidunt magnam qui corrupti qui qui officiis sint.', 292116421),
(8, 17, 20, 'Non debitis id nobis exercitationem suscipit.', 1054980039),
(9, 6, 22, 'Rerum voluptas est necessitatibus cumque.', 1399833408),
(10, 47, 22, 'Nostrum neque quia voluptas accusamus quia corrupti.', 1091932076),
(11, 34, 6, 'Qui quae repellendus ipsam totam quo.', 496854798),
(12, 34, 44, 'Maiores rerum et atque quia est et.', 717844064),
(13, 36, 30, 'Dolor laboriosam quis assumenda rem.', 58337089),
(14, 16, 4, 'Error voluptate aut dolorem similique.', 854461501),
(15, 30, 16, 'Ad qui expedita harum.', 694244399),
(16, 44, 3, 'Pariatur voluptas ex non earum.', 222886030),
(17, 43, 24, 'Illum porro ab beatae veritatis mollitia.', 455555702),
(18, 5, 35, 'Reiciendis aspernatur suscipit voluptatum nobis explicabo ut.', 952080987),
(19, 11, 36, 'Sit alias voluptatum debitis molestiae ipsam ut libero.', 1067325357),
(20, 5, 38, 'Et adipisci earum dolorum placeat veniam.', 546621171),
(21, 39, 26, 'Eaque ut id incidunt veritatis.', 238276786),
(22, 1, 41, 'Quis et sequi vel modi explicabo eos.', 237258563),
(23, 46, 36, 'Voluptates voluptatum veritatis quisquam adipisci sed porro ea.', 1412822206),
(24, 46, 5, 'Qui et dolorem ab accusamus nam enim sunt.', 1000538703),
(25, 17, 23, 'Repudiandae consequuntur et eveniet vero ut cupiditate nobis.', 892695796),
(26, 20, 21, 'Repellat autem odit quia asperiores sed suscipit alias.', 1256771899),
(27, 18, 30, 'Id consequatur perspiciatis ea cupiditate qui.', 829869523),
(28, 20, 26, 'Quia unde quia qui.', 751950462),
(29, 9, 24, 'Ipsa omnis minus in ipsam.', 524958417),
(30, 14, 36, 'Doloribus et et sunt laborum explicabo qui culpa.', 44101256),
(31, 35, 12, 'Omnis quod dolores officia sunt tempore ut.', 1233861681),
(32, 24, 8, 'Consequatur qui aliquid ipsa.', 663890183),
(33, 3, 8, 'Corrupti et itaque iure soluta vero eius omnis.', 1263267344),
(34, 29, 14, 'Facere ab amet ducimus dolor dolorem error provident aliquam.', 804052147),
(35, 1, 10, 'Assumenda laborum illum sed laboriosam consequuntur quo provident.', 570817536),
(36, 26, 14, 'Facere atque explicabo aut qui.', 575248330),
(37, 46, 29, 'Nostrum ipsum recusandae tenetur nostrum et aut.', 394845470),
(38, 11, 17, 'Quis facere aut quae sit fuga molestiae soluta et.', 1203073163),
(39, 20, 9, 'Accusamus velit aut quo ex.', 1183183191),
(40, 10, 45, 'Vel sequi perferendis dolor earum pariatur minus.', 1131143431),
(41, 32, 5, 'Voluptatem est aut esse voluptatem mollitia magnam.', 101575428),
(42, 36, 23, 'Explicabo facilis laudantium aut animi voluptas cupiditate tempora ut.', 220994956),
(43, 9, 49, 'Ipsam consequatur doloremque quaerat et et dolorem numquam.', 653245431),
(44, 41, 45, 'Repellat cumque quas aut omnis aperiam excepturi.', 1273033364),
(45, 49, 35, 'Ut at maiores ea.', 187263203),
(46, 15, 40, 'Minima nesciunt unde error modi.', 1251659480),
(47, 28, 1, 'Dolores doloremque pariatur provident non beatae qui voluptas.', 834063607),
(48, 50, 43, 'Quaerat repudiandae ut officiis quo aut soluta.', 10013802),
(49, 29, 29, 'Et voluptatem fugiat recusandae dolorum velit.', 327540808),
(50, 29, 37, 'Qui minima ducimus praesentium tempore ea qui.', 1257228693),
(51, 38, 10, 'Officia eos provident doloremque quibusdam placeat.', 918179918),
(52, 44, 3, 'Ea rerum aspernatur aut in minima soluta ea amet.', 1254834928),
(53, 1, 26, 'Vel quod voluptatibus nesciunt eveniet.', 400368074),
(54, 24, 8, 'Laborum perferendis dolorum aut quaerat.', 1078134590),
(55, 8, 3, 'Et fugit accusantium voluptatibus nihil sed.', 1173577126),
(56, 43, 31, 'Quisquam eligendi ratione eius eveniet suscipit dolor nesciunt.', 385224565),
(57, 45, 31, 'Aut sint soluta magni voluptates illo.', 819534947),
(58, 27, 3, 'Libero consequatur numquam aliquam est deleniti non dolorem.', 450724570),
(59, 9, 36, 'Voluptatem quisquam voluptatem vero voluptate quae illum.', 771473805),
(60, 22, 11, 'Quidem dolorum aut et ut fuga quia.', 1088157321),
(61, 14, 16, 'Eum ut maxime dolores veritatis non.', 940999378),
(62, 49, 34, 'Incidunt amet velit ut.', 1245066282),
(63, 35, 45, 'Quae quasi eaque nihil dolorem.', 297151268),
(64, 39, 19, 'Distinctio earum nobis aut aut doloribus recusandae sunt.', 578270777),
(65, 42, 45, 'Est doloribus qui dolores nihil quo ipsum.', 1349945937),
(66, 48, 29, 'Sint et ea totam hic eaque unde.', 1334176340),
(67, 8, 48, 'Repellendus eaque dolores et autem.', 1083328206),
(68, 16, 39, 'Incidunt rerum porro ullam adipisci molestiae ut.', 683287837),
(69, 36, 8, 'Eos tempora qui facere quas quis provident.', 290326541),
(70, 17, 34, 'Aut ut quia quia necessitatibus illo aperiam aperiam.', 641791070),
(71, 24, 9, 'Quo reprehenderit expedita aperiam quibusdam rerum nostrum sit.', 591511386),
(72, 39, 12, 'Autem sed minus beatae porro et aut voluptatem laborum.', 1120821844),
(73, 46, 11, 'Ducimus facere ducimus praesentium rerum voluptas.', 1415070571),
(74, 27, 18, 'Ipsam ea voluptatem placeat voluptas.', 1382348962),
(75, 44, 37, 'Dolores nulla et id sint corrupti voluptatem placeat.', 1236016119),
(76, 18, 13, 'Minus voluptatem ad illo quibusdam sit ea corrupti.', 378007363),
(77, 35, 46, 'Nemo omnis exercitationem vero enim fugiat.', 1210324739),
(78, 47, 28, 'In itaque repudiandae odit velit vel laudantium.', 1294624255),
(79, 13, 25, 'Ut omnis velit delectus accusamus eius molestiae.', 1328162539),
(80, 35, 1, 'Ut est nam dolorum vel saepe dolor omnis.', 1091114683),
(81, 21, 35, 'Qui sunt amet quia et velit consequatur.', 1351693745),
(82, 49, 3, 'Sint omnis fugiat quia sint et molestiae ipsam vel.', 605267412),
(83, 49, 19, 'Sunt nisi qui aliquid dignissimos autem.', 1096335054),
(84, 37, 9, 'Voluptatibus laborum ipsum nostrum explicabo quia veniam dolorem aut.', 1161829381),
(85, 37, 23, 'Sed et et eos soluta qui hic.', 45814863),
(86, 43, 32, 'Minima natus eos occaecati ut et eligendi.', 751889568),
(87, 6, 32, 'Quidem et voluptas velit eveniet.', 454640347),
(88, 49, 29, 'Itaque quidem et qui perspiciatis iure aut fugit.', 467879787),
(89, 22, 33, 'Aut itaque itaque repellat facere necessitatibus.', 1395537720),
(90, 34, 29, 'Cumque architecto laboriosam quia quasi et.', 1103315176),
(91, 3, 19, 'Est hic debitis blanditiis eius fugiat rerum.', 1087569267),
(92, 33, 12, 'Dolores molestiae eos culpa dolor maxime dolorem harum exercitationem.', 177899516),
(93, 9, 5, 'Sit omnis maiores quos quia.', 1178473292),
(94, 46, 48, 'Aut deleniti nesciunt cupiditate consectetur libero incidunt.', 204852841),
(95, 13, 31, 'Eveniet neque sit reiciendis aut similique.', 1100059709),
(96, 44, 37, 'Temporibus et voluptatum nobis non.', 961968499),
(97, 38, 44, 'Qui nulla fuga eum et.', 804048958),
(98, 26, 3, 'Totam sed voluptates atque quia qui.', 283653235),
(99, 19, 25, 'Dolorum illum recusandae quisquam soluta quia sit non.', 1164048779),
(100, 43, 40, 'Aut delectus quis minus sit ea.', 1224097814),
(101, 33, 17, 'Natus ipsum modi doloribus culpa sint.', 334583755),
(102, 26, 11, 'Rerum eius non animi ut.', 941048181),
(103, 21, 28, 'Suscipit voluptate repellat error rerum in in qui.', 216424198),
(104, 31, 14, 'Iure similique ipsam qui culpa.', 661785872),
(105, 37, 34, 'Saepe atque velit dignissimos ut excepturi provident explicabo.', 580961790),
(106, 11, 17, 'Et sed rerum facilis et sed doloribus porro.', 99703809),
(107, 38, 14, 'Iste excepturi doloremque eligendi id quas quasi perspiciatis.', 928215736),
(108, 12, 19, 'Dolores voluptates eveniet laudantium ut aut est.', 30616877),
(109, 16, 44, 'Adipisci unde aut rem corporis.', 1044927746),
(110, 31, 31, 'Dolores fuga voluptatem et.', 98131099),
(111, 8, 18, 'Rerum qui ut magnam illum aspernatur cupiditate fugit voluptatem.', 1281594724),
(112, 47, 21, 'Sequi aut autem voluptatem et necessitatibus aut animi quis.', 972860917),
(113, 15, 37, 'Ipsa dolorum illum et praesentium qui quos.', 682456548),
(114, 41, 35, 'Veniam est in non sunt eum ullam.', 1170212887),
(115, 12, 48, 'Beatae sed nihil aut similique magni.', 1270276928),
(116, 42, 5, 'Illum reiciendis repudiandae rerum in eum occaecati.', 1323562705),
(117, 26, 2, 'Aut illo eaque esse deleniti qui molestias.', 145344197),
(118, 48, 20, 'Error quas repellat alias perspiciatis dolores tenetur tempore.', 1308952476),
(119, 23, 47, 'Deleniti inventore quod quia quas.', 4040292),
(120, 41, 3, 'Ut et qui enim in autem omnis.', 652853808),
(121, 49, 27, 'Quaerat maiores placeat a voluptatem et excepturi quasi.', 1318911655),
(122, 16, 2, 'Vero eum laboriosam maxime minus voluptatum omnis non.', 701952014),
(123, 14, 28, 'Vel magni nam voluptates aliquam accusamus accusamus.', 909709782),
(124, 18, 31, 'Molestiae doloribus maxime commodi omnis.', 1381979183),
(125, 1, 50, 'Iusto et itaque reprehenderit ea.', 1048987918),
(126, 4, 19, 'Quia eius in necessitatibus blanditiis assumenda omnis.', 935074634),
(127, 4, 42, 'Quisquam quia incidunt incidunt et fugiat.', 191972855),
(128, 9, 48, 'Quia veritatis unde dolore non.', 1010694858),
(129, 15, 17, 'Odit autem iure fuga eum aperiam consequatur velit quis.', 553601789),
(130, 37, 49, 'Porro qui velit maxime deserunt et ea.', 1242756187),
(131, 19, 12, 'Ut et consectetur aut aut vel mollitia nobis.', 761584383),
(132, 33, 27, 'Eaque atque est officia dicta illo ut.', 590227362),
(133, 2, 25, 'Dolorem impedit perferendis sed dolorum tempora pariatur.', 361251395),
(134, 29, 24, 'Est qui officia nihil minus ad facilis rerum.', 369830640),
(135, 36, 23, 'Commodi optio dolorum harum at in voluptate.', 1366512065),
(136, 39, 38, 'Et corporis quod ab maxime aut.', 802303700),
(137, 9, 2, 'Fugit et qui aperiam ut ut.', 1228570888),
(138, 36, 16, 'Rerum suscipit asperiores dolore autem.', 160887646),
(139, 24, 10, 'Consectetur soluta enim voluptatem odio corporis.', 312646827),
(140, 20, 25, 'Commodi inventore et quo quos iusto id.', 112738487),
(141, 40, 19, 'Id dolore rem earum dolorum esse.', 46245609),
(142, 32, 26, 'Et vel voluptas eum harum nostrum delectus saepe vitae.', 1295548318),
(143, 19, 9, 'Possimus mollitia ea sed aut et perferendis.', 252488473),
(144, 46, 30, 'Quibusdam accusantium ad dolores dolor.', 788742045),
(145, 1, 9, 'Commodi et quia qui.', 1064382487),
(146, 10, 42, 'Assumenda est optio officia occaecati doloremque ab aut.', 878508856),
(147, 3, 13, 'Quam est aut soluta vero nesciunt facilis illo.', 197412309),
(148, 36, 31, 'Eveniet sit deserunt corporis aut dolores et.', 796636261),
(149, 17, 26, 'Sint ea ea consequatur quo eum molestiae.', 109612782),
(150, 3, 26, 'Voluptas perspiciatis doloremque dolores omnis et dolor.', 1304581491),
(151, 20, 11, 'Aut ut ullam nisi alias tenetur illum.', 536533841),
(152, 17, 47, 'Deleniti illo ea repellendus sed.', 256994384),
(153, 5, 15, 'Cum placeat eveniet modi recusandae voluptatem.', 825118866),
(154, 2, 31, 'Ut voluptas nesciunt et dolor vel totam fuga est.', 834213419),
(155, 3, 19, 'Sunt dicta fugit voluptas eaque sequi.', 1206512159),
(156, 25, 30, 'Aut sed aut eius excepturi.', 440606911),
(157, 11, 16, 'Id et molestiae eos ad dolores.', 162349056),
(158, 4, 1, 'Voluptatem vero nesciunt quisquam et tempore tempore eum.', 807983593),
(159, 42, 5, 'Et minus repellendus iure ea alias ut et.', 1183928534),
(160, 9, 48, 'Dignissimos debitis non est ut.', 922607420),
(161, 14, 10, 'Fugit in doloremque ipsam.', 1399435904),
(162, 44, 8, 'Et aut quibusdam incidunt ut voluptatibus dolorem.', 1088327712),
(163, 46, 25, 'Consequatur iusto suscipit velit nisi omnis quae deleniti.', 786392575),
(164, 22, 7, 'Et eveniet hic et consequuntur vero eum.', 1375982861),
(165, 47, 35, 'Consequatur quod esse quis illum incidunt vero necessitatibus nulla.', 52295287),
(166, 27, 11, 'Et sunt unde ut dolorem est quo ratione.', 181994214),
(167, 49, 1, 'Voluptatum voluptatem quam consequatur deleniti voluptatem magnam.', 583349162),
(168, 21, 37, 'Et et magnam voluptates labore et a.', 420174067),
(169, 35, 30, 'Laboriosam et natus modi optio sit aliquid.', 1234672480),
(170, 25, 48, 'Aut itaque voluptatem dolor consequatur et.', 1174131666),
(171, 40, 46, 'Ea quis velit et sequi at ut.', 1312848465),
(172, 27, 35, 'Aut enim consequatur esse deserunt quasi.', 1259004263),
(173, 25, 10, 'Necessitatibus suscipit in neque consequatur.', 386701080),
(174, 20, 20, 'Voluptatum dicta doloremque dolorem ut amet molestiae voluptatem.', 1344533304),
(175, 20, 13, 'Est quaerat dolorem recusandae vel accusamus quia ipsam porro.', 392422283),
(176, 47, 5, 'Sed recusandae aut voluptatem sed voluptatum.', 1090652297),
(177, 4, 39, 'Et quod eum optio aliquam quisquam.', 924196243),
(178, 6, 39, 'Enim culpa tempore minus porro.', 1042154949),
(179, 44, 21, 'Eveniet eos ipsam placeat incidunt.', 491948039),
(180, 22, 24, 'Et ex fuga quas occaecati tenetur suscipit.', 129109496),
(181, 19, 9, 'Recusandae iure deleniti omnis amet error blanditiis quis.', 414058235),
(182, 13, 39, 'Asperiores vero alias dolores molestiae.', 645368939),
(184, 40, 47, 'Ipsum dolor enim est odio.', 471717110),
(185, 18, 24, 'Itaque asperiores qui dignissimos placeat quaerat.', 579941116),
(186, 9, 13, 'Ipsam aut ea quam adipisci amet molestiae minima.', 204413430),
(187, 19, 28, 'Quia mollitia numquam reiciendis.', 702446132),
(188, 50, 42, 'Quia omnis enim cupiditate assumenda et harum.', 8039111),
(189, 14, 5, 'Consequatur occaecati nostrum expedita molestiae alias totam facilis recusandae.', 1134497557),
(190, 18, 42, 'Magni est recusandae blanditiis repellendus quisquam dolores.', 679641776),
(191, 12, 42, 'Similique et magnam est et eum voluptatem.', 73690647),
(192, 28, 12, 'Enim atque cumque doloremque maxime.', 382601104),
(193, 33, 10, 'Quo quisquam nesciunt alias rerum est ducimus recusandae.', 1032420287),
(194, 23, 47, 'Tempora architecto quaerat aut voluptate.', 966016791),
(195, 34, 22, 'Veniam omnis sunt laudantium at laudantium voluptate cupiditate.', 827486806),
(196, 17, 40, 'Veniam porro est architecto optio aperiam minus voluptatum illum.', 1331522171),
(197, 30, 47, 'Quis quibusdam est voluptates est error.', 22615740),
(198, 43, 13, 'Voluptas amet soluta quaerat.', 652211043),
(199, 47, 30, 'Expedita delectus commodi vel veritatis et sequi.', 1004557408),
(200, 19, 17, 'Fuga a adipisci voluptas sed dolor culpa pariatur dolorem.', 1349239103),
(201, 29, 13, 'Facere sint officiis eum doloremque similique voluptatem.', 695135457),
(202, 44, 3, 'Molestiae omnis occaecati ducimus atque est.', 245214961),
(203, 29, 2, 'Necessitatibus unde cupiditate tenetur earum voluptatem.', 1036428631),
(204, 40, 17, 'Maxime repellendus qui cupiditate.', 1238735852),
(205, 21, 45, 'Voluptatibus molestiae omnis animi suscipit rem.', 983057999),
(206, 1, 2, 'whats up olein', 855400036),
(207, 1, 49, 'hi max', 1417493032),
(209, 1, 49, 'how are you max ?', 1417567600),
(210, 1, 2, 'olein i have added ajax msg :D', 1417569513),
(211, 1, 3, 'hi venum :)', 1417572559),
(212, 1, 35, 'hei Dewayne', 1418478371);

-- --------------------------------------------------------

--
-- Table structure for table `participant`
--

CREATE TABLE IF NOT EXISTS `participant` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `content_id` int(11) NOT NULL,
  `user_id` int(11) NOT NULL,
  `active` int(11) NOT NULL,
  PRIMARY KEY (`id`),
  KEY `user_id_idx` (`user_id`),
  KEY `content_id_idx` (`content_id`)
) ENGINE=InnoDB  DEFAULT CHARSET=utf8 AUTO_INCREMENT=21 ;

--
-- Dumping data for table `participant`
--

INSERT INTO `participant` (`id`, `content_id`, `user_id`, `active`) VALUES
(1, 13, 1, 1),
(2, 18, 1, 1),
(4, 32, 1, 1),
(7, 27, 1, 1),
(8, 26, 1, 1),
(9, 11, 1, 1),
(10, 10, 1, 1),
(11, 32, 52, 1),
(12, 9, 1, 1),
(13, 32, 3, 1),
(14, 9, 3, 1),
(15, 9, 7, 1),
(16, 9, 10, 1),
(17, 11, 4, 1),
(18, 11, 6, 1),
(19, 11, 7, 1),
(20, 11, 10, 1);

-- --------------------------------------------------------

--
-- Table structure for table `user`
--

CREATE TABLE IF NOT EXISTS `user` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `email` varchar(100) NOT NULL,
  `password` varchar(32) NOT NULL,
  `first_name` varchar(30) NOT NULL,
  `last_name` varchar(30) NOT NULL,
  `address` varchar(255) NOT NULL,
  `district` varchar(50) NOT NULL,
  `date_of_birth` int(11) NOT NULL,
  `gender` int(1) NOT NULL,
  `type` int(1) NOT NULL,
  `last_login_at` int(11) NOT NULL,
  `allow_message` int(1) NOT NULL,
  `status` int(1) NOT NULL,
  `token` varchar(8) NOT NULL,
  `created_at` int(11) NOT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB  DEFAULT CHARSET=utf8 AUTO_INCREMENT=53 ;

--
-- Dumping data for table `user`
--

INSERT INTO `user` (`id`, `email`, `password`, `first_name`, `last_name`, `address`, `district`, `date_of_birth`, `gender`, `type`, `last_login_at`, `allow_message`, `status`, `token`, `created_at`) VALUES
(1, 'leninhasda@gmail.com', '5f4dcc3b5aa765d61d8327deb882cf99', 'Lenin', 'Hasda', 'gulshan-2, dhaka-1212', 'Dhaka', 1415383200, 1, 1, 1416441264, 1, 1, '', 1416441264),
(2, 'olein92@gmail.com', '5f4dcc3b5aa765d61d8327deb882cf99', 'olein', 'fahim', 'shamoly', 'dhaka', 1417284000, 1, 2, 1416441264, 1, 1, '1', 1416441264),
(3, 'maia36@kihn.com', '5f4dcc3b5aa765d61d8327deb882cf99', 'Jakayla', 'Veum', '12855 Hintz Hollow Apt. 005\nFaustinohaven, NV 88643-3761', 'rangamati ', 228306720, 2, 3, 1187358039, 1, 1, '', 53754184),
(4, 'reece.hirthe@bruenwunsch.com', '5f4dcc3b5aa765d61d8327deb882cf99', 'Rebekah', 'Ziemann', '63558 Electa Ford Suite 300\nSouth Regan, KS 35858-5068', 'bandarban', 683146927, 2, 1, 1236474623, 1, 1, '', 12309456),
(5, 'hermann.kaela@yahoo.com', '5f4dcc3b5aa765d61d8327deb882cf99', 'Buster', 'Bahringer', '568 Kuhn Point Apt. 772\nSouth Sydnie, MO 52379-7761', 'chandpur', 411608848, 2, 3, 715678342, 1, 1, '', 1344922014),
(6, 'ehamill@auergoodwin.biz', '5f4dcc3b5aa765d61d8327deb882cf99', 'Otho', 'Beer', '7348 Schinner Mount\nLangoshstad, ID 94772', 'munshiganj', 355314121, 2, 3, 914206355, 1, 1, '', 1225626073),
(7, 'charris@yahoo.com', '5f4dcc3b5aa765d61d8327deb882cf99', 'Deja', 'Pfannerstill', '379 Lesch Parkway Suite 614\nLeanneville, AL 77560-2655', 'feni', 725979893, 1, 3, 653998548, 1, 1, '', 407207374),
(8, 'destiney.schowalter@hotmail.com', '5f4dcc3b5aa765d61d8327deb882cf99', 'Madaline', 'Mitchell', '99318 Mittie Burg\nBrownmouth, UT 52610-8166', 'narayanganj', 929559933, 1, 3, 763432875, 1, 1, '', 67904454),
(9, 'mya.ward@friesenconnelly.com', '5f4dcc3b5aa765d61d8327deb882cf99', 'Margie', 'Hickle', '033 Vivian Turnpike\nPort Aftonshire, CO 86408-2364', 'khagrachhari', 1383007435, 1, 3, 394138384, 1, 1, '', 375743113),
(10, 'schmeler.jayme@parisiantremblay.com', '5f4dcc3b5aa765d61d8327deb882cf99', 'Pearl', 'Hauck', '70142 Marley Flats Apt. 196\nO''Keefeborough, UT 81470', 'mymensingh', 24226932, 2, 1, 150463464, 1, 1, '', 925493598),
(11, 'marilyne27@yahoo.com', '5f4dcc3b5aa765d61d8327deb882cf99', 'Virgie', 'Leannon', '891 Nienow Fords Apt. 790\nLittelmouth, GA 65789-0123', 'barguna', 791222543, 2, 1, 1285934286, 1, 1, '', 522735709),
(12, 'yundt.melvin@berge.com', '5f4dcc3b5aa765d61d8327deb882cf99', 'Dock', 'Hyatt', '2253 Eleonore Lodge Suite 527\nKemmertown, LA 61942-3644', 'barguna', 53487635, 2, 1, 715951512, 1, 1, '', 906968913),
(13, 'grady.johnnie@gmail.com', '5f4dcc3b5aa765d61d8327deb882cf99', 'Dante', 'Zulauf', '79106 Trinity Extension\nLake Kieranborough, IN 10492-9503', 'manikganj', 1287183522, 1, 1, 1275119830, 1, 1, '', 1074054291),
(14, 'tmann@von.biz', '5f4dcc3b5aa765d61d8327deb882cf99', 'Peyton', 'Walter', '70832 Weissnat Extensions\nNorth Maureen, TN 21047-6634', 'chittagong', 1359928355, 1, 3, 692490159, 1, 1, '', 1052945567),
(15, 'wgutmann@ortiz.com', '5f4dcc3b5aa765d61d8327deb882cf99', 'Elda', 'Gleason', '03003 Schiller Crossing\nThielstad, DC 36627-4317', 'noakhali', 1028842068, 2, 3, 445715811, 1, 1, '', 163303869),
(16, 'dach.minerva@hotmail.com', '5f4dcc3b5aa765d61d8327deb882cf99', 'Deondre', 'Abbott', '899 Jaycee Place Suite 994\nEast Adellemouth, GA 56480-8573', 'sherpur', 839168905, 1, 2, 811544217, 1, 1, '', 510502843),
(17, 'prolfson@hotmail.com', '5f4dcc3b5aa765d61d8327deb882cf99', 'Karson', 'Hermann', '078 Brandt Lights Apt. 512\nNew Daniellaside, AR 42494', 'jamalpur', 640985195, 1, 1, 494042952, 1, 1, '', 1362970879),
(18, 'gibson.minnie@rice.com', '5f4dcc3b5aa765d61d8327deb882cf99', 'Jeffery', 'Barrows', '7584 Eliseo Plains Suite 172\nPort Frederickport, ME 41880-1317', 'mymensingh', 494220632, 2, 2, 458368604, 1, 1, '', 841434942),
(19, 'kemmer.harley@hotmail.com', '5f4dcc3b5aa765d61d8327deb882cf99', 'Zora', 'Murray', '30942 Iliana Estate\nRobelmouth, NE 92310', 'khagrachhari', 446974614, 1, 2, 727205047, 1, 1, '', 1297375552),
(20, 'price.ubaldo@mayer.com', '5f4dcc3b5aa765d61d8327deb882cf99', 'Joanie', 'Kemmer', '0834 Eldora Canyon\nLeehaven, NE 81543-1053', 'chandpur', 380540585, 2, 1, 151595543, 1, 1, '', 1309631480),
(21, 'gstehr@kub.com', '5f4dcc3b5aa765d61d8327deb882cf99', 'Kaitlyn', 'Wolf', '89405 Greenfelder Forks Apt. 514\nSydnieburgh, NC 59907', 'narsingdi', 539970469, 2, 3, 726241716, 1, 1, '', 788914291),
(22, 'schultz.jazmyn@hotmail.com', '5f4dcc3b5aa765d61d8327deb882cf99', 'Easton', 'Abernathy', '795 Arno Lock\nWest Mableview, GA 98095-9022', 'barisal', 469970482, 2, 1, 224784290, 1, 1, '', 994068789),
(23, 'dkuhlman@yahoo.com', '5f4dcc3b5aa765d61d8327deb882cf99', 'Callie', 'Weimann', '54013 Hickle Street Apt. 054\nTerrenceland, IN 82846', 'narsingdi', 149570840, 2, 3, 631319786, 1, 1, '', 1029878866),
(24, 'sterling02@hoeger.com', '5f4dcc3b5aa765d61d8327deb882cf99', 'Charlene', 'Stanton', '185 Renner Camp\nPort Fernandochester, VT 48954', 'manikganj', 700584319, 2, 1, 944991270, 1, 1, '', 1186637979),
(25, 'feest.paris@yahoo.com', '5f4dcc3b5aa765d61d8327deb882cf99', 'Freida', 'Bode', '9142 Kyler Ville\nNorth Travisstad, AR 64975-4703', 'jamalpur', 257451677, 2, 2, 758502912, 1, 1, '', 548593924),
(26, 'alva.swaniawski@gmail.com', '5f4dcc3b5aa765d61d8327deb882cf99', 'Juliana', 'Douglas', '31168 Greenfelder Roads Suite 121\nEast Joyburgh, TX 95472-3657', 'narsingdi', 806373876, 1, 2, 164528419, 1, 1, '', 681789960),
(27, 'daniella.doyle@considinehills.com', '5f4dcc3b5aa765d61d8327deb882cf99', 'Domenica', 'Jerde', '96730 Beatty Valleys Apt. 120\nLake Christop, TN 96945-8857', 'chittagong', 1009152815, 2, 3, 274583048, 1, 1, '', 569846697),
(28, 'bnicolas@gmail.com', '5f4dcc3b5aa765d61d8327deb882cf99', 'Laurence', 'Bergstrom', '40361 Deanna Road Suite 634\nBradleyside, MI 08435', 'brahmanbaria', 786799657, 2, 1, 1100739613, 1, 1, '', 1013775697),
(29, 'sophie40@pouros.org', '5f4dcc3b5aa765d61d8327deb882cf99', 'Beau', 'Goldner', '1519 Alanna Stream\nSouth Velma, CO 25512-3424', 'narsingdi', 1015525254, 2, 3, 582991764, 1, 1, '', 155426756),
(30, 'queenie.daniel@yahoo.com', '5f4dcc3b5aa765d61d8327deb882cf99', 'Oral', 'Wyman', '31616 Alysa Trail Suite 440\nCaroletown, IN 48673', 'chandpur', 1089979562, 2, 3, 136352955, 1, 1, '', 851608172),
(31, 'prussel@gutmannstrosin.com', '5f4dcc3b5aa765d61d8327deb882cf99', 'Arturo', 'Mann', '73805 Kristy Viaduct\nLake Layla, WI 19992-8829', 'shariatpur', 965294193, 2, 2, 837255835, 1, 1, '', 179993996),
(32, 'jheller@wunsch.com', '5f4dcc3b5aa765d61d8327deb882cf99', 'Camryn', 'Reilly', '67927 Lind Passage\nOrionberg, SD 81626-4920', 'jhalokati', 76599213, 2, 2, 950982984, 1, 1, '', 1136907394),
(33, 'omer98@hotmail.com', '5f4dcc3b5aa765d61d8327deb882cf99', 'Jacklyn', 'Welch', '90729 Dietrich Shoals Suite 701\nLake Aglae, CA 98478', 'pirojpur', 197686734, 2, 1, 857323157, 1, 1, '', 317669721),
(34, 'theresa.kling@klinghowell.com', '5f4dcc3b5aa765d61d8327deb882cf99', 'Shyann', 'Rice', '91460 Wanda Manors Apt. 044\nHermannmouth, ID 39529', 'narayanganj', 1117136527, 1, 2, 22265005, 1, 1, '', 120263904),
(35, 'thaddeus.altenwerth@feeneypowlowski.org', '5f4dcc3b5aa765d61d8327deb882cf99', 'Dewayne', 'Gottlieb', '42436 Kuhic Glens\nCarolynberg, CO 23359', 'chandpur', 42341542, 1, 1, 673534702, 1, 1, '', 291133548),
(36, 'hirthe.sandrine@hotmail.com', '5f4dcc3b5aa765d61d8327deb882cf99', 'Jennyfer', 'Steuber', '607 Jettie Isle\nSonyaton, MO 10845-6395', 'tangail', 734371993, 2, 3, 516760456, 1, 1, '', 650636178),
(37, 'ibatz@hotmail.com', '5f4dcc3b5aa765d61d8327deb882cf99', 'Shanie', 'Stehr', '5195 Jaycee Alley\nReannafurt, NC 77500', 'faridpur', 621941267, 1, 3, 1212956891, 1, 1, '', 56948207),
(38, 'alemke@skiles.info', '5f4dcc3b5aa765d61d8327deb882cf99', 'Iliana', 'Baumbach', '78095 Rhett Crest\nNorth Oramouth, ME 42410', 'rangamati ', 646519197, 2, 2, 547713237, 1, 1, '', 1345494127),
(39, 'desmond.hamill@dibbert.com', '5f4dcc3b5aa765d61d8327deb882cf99', 'Camille', 'Hilll', '34219 Karlie Fords\nMalachiport, OH 23930-0041', 'jhalokati', 1161065737, 1, 3, 986232495, 1, 1, '', 172361140),
(40, 'richard.heidenreich@vonrueden.biz', '5f4dcc3b5aa765d61d8327deb882cf99', 'Beryl', 'Morar', '1376 Little Trafficway\nWunschville, MD 00721-6225', 'kishoregonj', 501915190, 1, 3, 1150330049, 1, 1, '', 1059849046),
(41, 'jerrell84@stromanlemke.com', '5f4dcc3b5aa765d61d8327deb882cf99', 'Ludie', 'Reichert', '8969 Brigitte Prairie Suite 471\nNorth Aglae, OH 68923', 'chandpur', 941630433, 2, 2, 533864821, 1, 1, '', 902330660),
(42, 'kaya.bergstrom@yahoo.com', '5f4dcc3b5aa765d61d8327deb882cf99', 'Ara', 'Russel', '3654 Shea Via\nWinifredport, TX 98389', 'mymensingh', 365797506, 1, 3, 1109416317, 1, 1, '', 697184094),
(43, 'heidenreich.layne@yahoo.com', '5f4dcc3b5aa765d61d8327deb882cf99', 'Brendan', 'Vandervort', '296 Gutmann Flat\nPort Arno, AR 00570', 'narayanganj', 885478313, 2, 2, 1011413293, 1, 1, '', 390824497),
(44, 'cassin.brianne@kundenolan.biz', '5f4dcc3b5aa765d61d8327deb882cf99', 'Alexane', 'Lubowitz', '47760 Reid Trail Apt. 932\nJerdehaven, AK 40677-0150', 'chandpur', 1351212534, 1, 3, 56050914, 1, 1, '', 1293625243),
(45, 'hermina.pagac@yahoo.com', '5f4dcc3b5aa765d61d8327deb882cf99', 'Bernadine', 'Dickinson', '39294 Yost Knolls Suite 765\nO''Konton, MO 94331', 'brahmanbaria', 1358860005, 2, 2, 918178915, 1, 1, '', 1003194508),
(46, 'korey.nitzsche@vandervortbeatty.info', '5f4dcc3b5aa765d61d8327deb882cf99', 'Bobbie', 'Rodriguez', '9683 Heidenreich Rue\nLuettgentown, KS 50185', 'chittagong', 1370956157, 2, 3, 689804731, 1, 1, '', 544539550),
(47, 'russel79@gmail.com', '5f4dcc3b5aa765d61d8327deb882cf99', 'Jammie', 'Hudson', '3120 Herzog Brooks\nNataliaburgh, UT 06068-5670', 'khagrachhari', 312461895, 1, 3, 294679850, 1, 1, '', 1328710399),
(48, 'taryn.crona@yahoo.com', '5f4dcc3b5aa765d61d8327deb882cf99', 'Lyda', 'Prosacco', '9808 Homenick Route\nEast Skylar, NY 08323-5314', 'narsingdi', 1214690579, 2, 1, 844885298, 1, 1, '', 561107981),
(49, 'leonor97@gerlach.biz', '5f4dcc3b5aa765d61d8327deb882cf99', 'Maxwell', 'Sawayn', '754 Velda Mountain Apt. 807\nMorarberg, NH 88904', 'gazipur', 681750976, 2, 3, 1255321161, 1, 1, '', 481122579),
(50, 'jaylan06@gerlach.org', '5f4dcc3b5aa765d61d8327deb882cf99', 'Rachelle', 'Cremin', '0686 Joshuah Radial\nLake Brooks, DE 88918-3238', 'rajbari', 94078884, 1, 3, 344341231, 1, 1, '', 800481516),
(51, 'arch32@hotmail.com', '5f4dcc3b5aa765d61d8327deb882cf99', 'Bo', 'Rolfson', '361 Veum Port\nWest Mia, FL 61104', 'cox''s bazar', 1065857131, 1, 2, 943526830, 1, 1, '', 411254976),
(52, 'dickens.reilly@oconnell.com', '5f4dcc3b5aa765d61d8327deb882cf99', 'Matt', 'Block', '50186 Rebeca Union\nDareberg, WA 92229-3314', 'gopalganj', 481740395, 1, 2, 352772152, 1, 1, '', 601819032);

--
-- Constraints for dumped tables
--

--
-- Constraints for table `education`
--
ALTER TABLE `education`
  ADD CONSTRAINT `user_id` FOREIGN KEY (`user_id`) REFERENCES `user` (`id`) ON DELETE NO ACTION ON UPDATE NO ACTION;

/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
