
use kargo_digitalAds;

ALTER TABLE `ads_campaign`
MODIFY COLUMN `unit_cost`  decimal(20,4) NOT NULL DEFAULT 0.000000 ,
MODIFY COLUMN `ads_url`  varchar(200) CHARACTER SET utf8 COLLATE utf8_bin NOT NULL DEFAULT '' ,
MODIFY COLUMN `ads_image`  varchar(200) CHARACTER SET utf8 COLLATE utf8_bin NOT NULL DEFAULT '' ;

ALTER TABLE `ads_campaign_history`
MODIFY COLUMN `unit_cost`  decimal(20,4) NOT NULL DEFAULT 0.000000 ,
MODIFY COLUMN `ads_url`  varchar(200) CHARACTER SET utf8 COLLATE utf8_bin NOT NULL DEFAULT '' ,
MODIFY COLUMN `ads_image`  varchar(200) CHARACTER SET utf8 COLLATE utf8_bin NOT NULL DEFAULT '';