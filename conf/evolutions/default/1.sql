# --- !Ups

--
-- Table for table `user`
--
CREATE TABLE `user` (
  `userID` varchar(255) NOT NULL,
  `firstName` varchar(255),
  `lastName` varchar(255),
  `fullName` varchar(255),
  `email` varchar(255),
  `avatarURL` varchar(255)
) ENGINE=InnoDB  DEFAULT CHARSET=utf8 ROW_FORMAT=COMPRESSED KEY_BLOCK_SIZE=8;

--
-- Table structure for table `logininfo`
--
CREATE TABLE `logininfo` (
  `id` bigint NOT NULL,
  `providerID` varchar(255) NOT NULL,
  `providerKey` varchar(255) NOT NULL
) ENGINE=InnoDB  DEFAULT CHARSET=utf8 ROW_FORMAT=COMPRESSED KEY_BLOCK_SIZE=8;

--
-- Table structure for table `userlogininfo`
--
CREATE TABLE `userlogininfo` (
  `userID` varchar(255) NOT NULL,
  `loginInfoId` bigint NOT NULL
) ENGINE=InnoDB  DEFAULT CHARSET=utf8 ROW_FORMAT=COMPRESSED KEY_BLOCK_SIZE=8;

--
-- Table structure for table `passwordinfo`
--
CREATE TABLE `passwordinfo` (
  `hasher` varchar(255) NOT NULL,
  `password` varchar(255) NOT NULL,
  `salt` varchar(255),
  `loginInfoId` bigint NOT NULL
) ENGINE=InnoDB  DEFAULT CHARSET=utf8 ROW_FORMAT=COMPRESSED KEY_BLOCK_SIZE=8;

--
-- Table structure for table `oauth1info`
--
CREATE TABLE `oauth1info` (
  `id` bigint NOT NULL,
  `token` varchar(255) NOT NULL,
  `secret` varchar(255) NOT NULL,
  `loginInfoId` bigint NOT NULL
) ENGINE=InnoDB  DEFAULT CHARSET=utf8 ROW_FORMAT=COMPRESSED KEY_BLOCK_SIZE=8;

--
-- Table structure for table `oauth2info`
--
CREATE TABLE `oauth2info` (
  `id` bigint NOT NULL,
  `accesstoken` varchar(255) NOT NULL,
  `tokentype` varchar(255),
  `expiresin` int,
  `refreshtoken` varchar(255),
  `loginInfoId` bigint NOT NULL
) ENGINE=InnoDB  DEFAULT CHARSET=utf8 ROW_FORMAT=COMPRESSED KEY_BLOCK_SIZE=8;

--
-- Table structure for table `openidinfo`
--
CREATE TABLE `openidinfo` (
  `id` varchar(255) NOT NULL,
  `loginInfoId` bigint NOT NULL
) ENGINE=InnoDB  DEFAULT CHARSET=utf8 ROW_FORMAT=COMPRESSED KEY_BLOCK_SIZE=8;

--
-- Table structure for table `openidattributes`
--
CREATE TABLE `openidattributes` (
  `id` varchar(255) NOT NULL,
  `key` varchar(255) NOT NULL,
  `value` varchar(255) NOT NULL
) ENGINE=InnoDB  DEFAULT CHARSET=utf8 ROW_FORMAT=COMPRESSED KEY_BLOCK_SIZE=8;

--
-- Indexes for dumped tables
--

--
-- Indexes for table `user`
--
ALTER TABLE `user`
ADD PRIMARY KEY (`userID`);

--
-- Indexes for table `logininfo`
--
ALTER TABLE `logininfo`
ADD PRIMARY KEY (`id`);

--
-- Indexes for table `oauth1info`
--
ALTER TABLE `oauth1info`
ADD PRIMARY KEY (`id`);

--
-- Indexes for table `oauth2info`
--
ALTER TABLE `oauth2info`
ADD PRIMARY KEY (`id`);

--
-- Indexes for table `openidinfo`
--
ALTER TABLE `openidinfo`
ADD PRIMARY KEY (`id`);

--
-- AUTO_INCREMENT for dumped tables
--

--
-- AUTO_INCREMENT for table `logininfo`
--
ALTER TABLE `logininfo`
MODIFY `ID` int NOT NULL AUTO_INCREMENT,AUTO_INCREMENT=1;

--
-- AUTO_INCREMENT for table `oauth1info`
--
ALTER TABLE `oauth1info`
MODIFY `ID` int NOT NULL AUTO_INCREMENT,AUTO_INCREMENT=1;

--
-- AUTO_INCREMENT for table `1oauth2info`
--
ALTER TABLE `oauth2info`
MODIFY `ID` int NOT NULL AUTO_INCREMENT,AUTO_INCREMENT=1;


# --- !Downs

drop table `openidattributes`;
drop table `openidinfo`;
drop table `oauth2info`;
drop table `oauth1info`;
drop table `passwordinfo`;
drop table `userlogininfo`;
drop table `logininfo`;
drop table `user`;