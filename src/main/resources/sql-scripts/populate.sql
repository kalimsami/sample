/*
Navicat MySQL Data Transfer

Source Server         : localhost_3309
Source Server Version : 50617
Source Host           : localhost:3309
Source Database       : shoppree

Target Server Type    : MYSQL
Target Server Version : 50617
File Encoding         : 65001

Date: 2016-02-05 22:42:54
*/

USE SHOPPREE;

SET FOREIGN_KEY_CHECKS=0;

-- ----------------------------
-- Records of benefits_desc
-- ----------------------------
INSERT INTO `benefits_desc` VALUES ('14', 'Unlimited complimentary Airport lounge access worldwide', 'atm', '11', '2016-01-30 22:04:40', '1');
INSERT INTO `benefits_desc` VALUES ('15', 'AL BARSHA (MIXED & LADIES ONLY)', 'gym', '12', '2016-01-30 22:10:16', '1');
INSERT INTO `benefits_desc` VALUES ('16', '25% Discount on Food and Beverage', 'restaurant', '13', '2016-01-30 22:16:07', '1');
INSERT INTO `benefits_desc` VALUES ('18', 'Sale Upto 75% Off on your Favorite Shoes & Accessories', 'store', '14', '2016-01-30 22:32:19', '1');


-- ----------------------------
-- Records of benefits_loc
-- ----------------------------
INSERT INTO `benefits_loc` VALUES ('38', 'Emirates NBD Building, First Al khail Street, Al Barsha 2 - United Arab Emirates', '25.1066302', '55.20424969999999', '14', '11', '2016-01-31 13:46:38', '1');
INSERT INTO `benefits_loc` VALUES ('39', 'Al Maktoum Rd - Dubai - United Arab Emirates', '25.2604642', '55.322440599999936', '14', '11', '2016-01-31 12:40:37', '1');
INSERT INTO `benefits_loc` VALUES ('40', 'Emirates NBD Building, Al Wasl Rd Intersection, Umm Suquiem 3, Jumeira - United Arab Emirates', '25.1396539', '55.19102650000002', '14', '11', '2016-01-31 13:46:15', '1');
INSERT INTO `benefits_loc` VALUES ('41', 'Next to MH Al Shaya - Al Mafraq Rd - Dubai - United Arab Emirates', '25.10727039999999', '55.19820119999997', '15', '12', '2016-01-31 12:40:39', '1');
INSERT INTO `benefits_loc` VALUES ('42', 'Sheikh Mohammed bin Rashid Blvd - United Arab Emirates', '25.193109', '55.272144000000026', '16', '13', '2016-01-31 13:46:23', '1');
INSERT INTO `benefits_loc` VALUES ('43', 'Deira Al Muraqabat - Dubai - United Arab Emirates', '25.26944', '55.30864999999994', '16', '13', '2016-01-31 12:40:40', '1');
INSERT INTO `benefits_loc` VALUES ('44', 'Madinat Zayed - Abu Dhabi - United Arab Emirates', '24.480742', '54.364919999999984', '17', '14', '2016-01-31 12:40:41', '1');
INSERT INTO `benefits_loc` VALUES ('45', 'Mall of the Emirates, Sheikh Zayed Rd. - Dubai - United Arab Emirates', '25.1169196', '55.202683200000024', '18', '14', '2016-01-31 12:40:42', '1');
INSERT INTO `benefits_loc` VALUES ('46', 'Shop No.191,India Court,Ibn Battuta Mall - Sheikh Zayed Road - United Arab Emirates', '25.0475613', '55.12096169999995', '18', '14', '2016-01-31 13:46:28', '1');


-- ----------------------------
-- Records of business_details
-- ----------------------------
INSERT INTO `business_details` VALUES ('11', 'Emirates NBD', 'Emirates NBD, the leading banking group in the region, was formed on 16th of October 2007 when the shares of Emirates NBD were officially listed on the Dubai Financial Market (DFM). The Emirates NBD 2007 merger between Emirates Bank International (EBI) and the National Bank of Dubai (NBD), became a regional consolidation blueprint for the banking and finance sector as it combined the second and fourth largest banks in the United Arab Emirates (UAE) to form a banking champion capable of delivering enhanced value across corporate, retail, private, Islamic and investment banking throughout the region.\r\n\r\n', '11.png', 'http://www.emiratesnbd.com/', '+971 600 540040', '2016-01-30 22:03:26', '1');
INSERT INTO `business_details` VALUES ('12', 'Fitness First', 'Fitness First is one of the worldâ€™s leading health and fitness companies owned and operated by Landmark Group, a leading retail organization in the Middle East and India. We have over 70,000 members in 61 clubs in 48 locations across the UAE, Bahrain, Qatar, Saudi Arabia, Jordan and Kuwait.\r\n\r\nWe offer world class facilities including; best in class equipment, an array of innovative programmes, cardio, strength and freestyle areas, internationally accredited fitness professionals, free group exercise classes and multiple membership privileges.\r\n\r\n', '12.png', 'http://www.fitnessfirstme.com/', '800 - 3486377', '2016-01-30 22:08:13', '1');
INSERT INTO `business_details` VALUES ('13', 'Mazaya', 'By becoming a My Mazaya member, you will automatically enroll in the classic tier and benefit from 25% discount on food and beverage and room rates at participating hotels across the Middle East. \r\n\r\nWhether itâ€™s to discuss business over your lunch hour, celebrate your anniversary, or surprise your loved one with a weekend getaway', '13.png', 'https://www.mymazayame.com/', '+(971) 4 294 5920/21/22', '2016-01-30 22:12:53', '1');
INSERT INTO `business_details` VALUES ('14', 'Shukran', 'Shukran is the Landmark Group\'s loyalty programme which rewards you with Shukrans-\r\nthe best currency ever, each time you shop at the partner stores.\r\nIts the currency you will earn each time you shop at Landmark Group stores, even when a sale or promotion in on. You can then choose to spend your Shurkans at any of our 45+ brands for over a million products. The possibilities are endless.\r\n\r\n', '14.png', 'https://www.shukranrewards.com', '+971 600 540040', '2016-01-30 22:31:09', '1');


-- ----------------------------
-- Records of category
-- ----------------------------
INSERT INTO `category` VALUES ('accounting', 'Accounting');
INSERT INTO `category` VALUES ('airport', 'Airport');
INSERT INTO `category` VALUES ('amusement_park', 'Amusement Park');
INSERT INTO `category` VALUES ('aquarium', 'Aquarium');
INSERT INTO `category` VALUES ('art_gallery', 'Art Gallery');
INSERT INTO `category` VALUES ('atm', 'Atm');
INSERT INTO `category` VALUES ('bakery', 'Bakery');
INSERT INTO `category` VALUES ('bank', 'Bank');
INSERT INTO `category` VALUES ('bar', 'Bar');
INSERT INTO `category` VALUES ('beauty_salon', 'Beauty Salon');
INSERT INTO `category` VALUES ('bicycle_store', 'Bicycle Store');
INSERT INTO `category` VALUES ('book_store', 'Book Store');
INSERT INTO `category` VALUES ('bowling_alley', 'Bowling Alley');
INSERT INTO `category` VALUES ('bus_station', 'Bus Station');
INSERT INTO `category` VALUES ('cafe', 'Cafe');
INSERT INTO `category` VALUES ('campground', 'Campground');
INSERT INTO `category` VALUES ('car_dealer', 'Car Dealer');
INSERT INTO `category` VALUES ('car_rental', 'Car Rental');
INSERT INTO `category` VALUES ('car_repair', 'Car Repair');
INSERT INTO `category` VALUES ('car_wash', 'Car Wash');
INSERT INTO `category` VALUES ('casino', 'Casino');
INSERT INTO `category` VALUES ('cemetery', 'Cemetery');
INSERT INTO `category` VALUES ('church', 'Church');
INSERT INTO `category` VALUES ('city_hall', 'City Hall');
INSERT INTO `category` VALUES ('clothing_store', 'Clothing Store');
INSERT INTO `category` VALUES ('convenience_store', 'Convenience Store');
INSERT INTO `category` VALUES ('courthouse', 'Courthouse');
INSERT INTO `category` VALUES ('dentist', 'Dentist');
INSERT INTO `category` VALUES ('department_store', 'Department Store');
INSERT INTO `category` VALUES ('doctor', 'Doctor');
INSERT INTO `category` VALUES ('electrician', 'Electrician');
INSERT INTO `category` VALUES ('electronics_store', 'Electronics Store');
INSERT INTO `category` VALUES ('embassy', 'Embassy');
INSERT INTO `category` VALUES ('establishment', 'Establishment');
INSERT INTO `category` VALUES ('finance', 'Finance');
INSERT INTO `category` VALUES ('fire_station', 'Fire Station');
INSERT INTO `category` VALUES ('florist', 'Florist');
INSERT INTO `category` VALUES ('food', 'Food');
INSERT INTO `category` VALUES ('funeral_home', 'Funeral Home');
INSERT INTO `category` VALUES ('furniture_store', 'Furniture Store');
INSERT INTO `category` VALUES ('gas_station', 'Gas Station');
INSERT INTO `category` VALUES ('general_contractor', 'General Contractor');
INSERT INTO `category` VALUES ('grocery_or_supermarket', 'Grocery Or Supermarket');
INSERT INTO `category` VALUES ('gym', 'Gym');
INSERT INTO `category` VALUES ('hair_care', 'Hair Care');
INSERT INTO `category` VALUES ('hardware_store', 'Hardware Store');
INSERT INTO `category` VALUES ('health', 'Health');
INSERT INTO `category` VALUES ('hindu_temple', 'Hindu Temple');
INSERT INTO `category` VALUES ('home_goods_store', 'Home Goods Store');
INSERT INTO `category` VALUES ('hospital', 'Hospital');
INSERT INTO `category` VALUES ('insurance_agency', 'Insurance Agency');
INSERT INTO `category` VALUES ('jewelry_store', 'Jewelry Store');
INSERT INTO `category` VALUES ('laundry', 'Laundry');
INSERT INTO `category` VALUES ('lawyer', 'Lawyer');
INSERT INTO `category` VALUES ('library', 'Library');
INSERT INTO `category` VALUES ('liquor_store', 'Liquor Store');
INSERT INTO `category` VALUES ('local_government_office', 'Local Government Office');
INSERT INTO `category` VALUES ('locksmith', 'Locksmith');
INSERT INTO `category` VALUES ('lodging', 'Lodging');
INSERT INTO `category` VALUES ('meal_delivery', 'Meal Delivery');
INSERT INTO `category` VALUES ('meal_takeaway', 'Meal Takeaway');
INSERT INTO `category` VALUES ('mosque', 'Mosque');
INSERT INTO `category` VALUES ('movie_rental', 'Movie Rental');
INSERT INTO `category` VALUES ('movie_theater', 'Movie Theater');
INSERT INTO `category` VALUES ('moving_company', 'Moving Company');
INSERT INTO `category` VALUES ('museum', 'Museum');
INSERT INTO `category` VALUES ('night_club', 'Night Club');
INSERT INTO `category` VALUES ('painter', 'Painter');
INSERT INTO `category` VALUES ('park', 'Park');
INSERT INTO `category` VALUES ('parking', 'Parking');
INSERT INTO `category` VALUES ('pet_store', 'Pet Store');
INSERT INTO `category` VALUES ('pharmacy', 'Pharmacy');
INSERT INTO `category` VALUES ('physiotherapist', 'Physiotherapist');
INSERT INTO `category` VALUES ('place_of_worship', 'Place Of Worship');
INSERT INTO `category` VALUES ('plumber', 'Plumber');
INSERT INTO `category` VALUES ('police', 'Police');
INSERT INTO `category` VALUES ('post_office', 'Post Office');
INSERT INTO `category` VALUES ('real_estate_agency', 'Real Estate Agency');
INSERT INTO `category` VALUES ('restaurant', 'Restaurant');
INSERT INTO `category` VALUES ('roofing_contractor', 'Roofing Contractor');
INSERT INTO `category` VALUES ('rv_park', 'Rv Park');
INSERT INTO `category` VALUES ('school', 'School');
INSERT INTO `category` VALUES ('shoe_store', 'Shoe Store');
INSERT INTO `category` VALUES ('shopping_mall', 'Shopping Mall');
INSERT INTO `category` VALUES ('spa', 'Spa');
INSERT INTO `category` VALUES ('stadium', 'Stadium');
INSERT INTO `category` VALUES ('storage', 'Storage');
INSERT INTO `category` VALUES ('store', 'Store');
INSERT INTO `category` VALUES ('subway_station', 'Subway Station');
INSERT INTO `category` VALUES ('synagogue', 'Synagogue');
INSERT INTO `category` VALUES ('taxi_stand', 'Taxi Stand');
INSERT INTO `category` VALUES ('train_station', 'Train Station');
INSERT INTO `category` VALUES ('travel_agency', 'Travel Agency');
INSERT INTO `category` VALUES ('university', 'University');
INSERT INTO `category` VALUES ('veterinary_care', 'Veterinary Care');
INSERT INTO `category` VALUES ('zoo', 'Zoo');


-- ----------------------------
-- Records of imported_products
-- ----------------------------
INSERT INTO `imported_products` VALUES ('1', '1', 'Nike Shoes', 'Nike Shoes', '1', '4000', 'simple');
INSERT INTO `imported_products` VALUES ('2', '2', 'Puma Shoes', 'Nike Shoes-1', '1', '300', 'simple');
INSERT INTO `imported_products` VALUES ('3', '3', 'Reebok shoes', 'Nike shoes-2', '1', '600', 'simple');
INSERT INTO `imported_products` VALUES ('4', '4', 'Lee Shirt', 'Lee Shirt', '1', '600', 'simple');
INSERT INTO `imported_products` VALUES ('5', '5', 'Zodiac Shirt', 'Zodiac Shirt', '1', '500', 'virtual');
