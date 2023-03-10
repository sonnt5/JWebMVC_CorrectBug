USE [JWebMVCDemo]
GO
/****** Object:  Table [dbo].[AccountTBL]    Script Date: 1/8/2023 10:58:06 PM ******/
SET ANSI_NULLS ON
GO
SET QUOTED_IDENTIFIER ON
GO
CREATE TABLE [dbo].[AccountTBL](
	[username] [varchar](150) NOT NULL,
	[password] [varchar](150) NOT NULL,
 CONSTRAINT [PK_AccountTBL] PRIMARY KEY CLUSTERED 
(
	[username] ASC
)WITH (PAD_INDEX = OFF, STATISTICS_NORECOMPUTE = OFF, IGNORE_DUP_KEY = OFF, ALLOW_ROW_LOCKS = ON, ALLOW_PAGE_LOCKS = ON, OPTIMIZE_FOR_SEQUENTIAL_KEY = OFF) ON [PRIMARY]
) ON [PRIMARY]
GO
/****** Object:  Table [dbo].[StudentTBL]    Script Date: 1/8/2023 10:58:07 PM ******/
SET ANSI_NULLS ON
GO
SET QUOTED_IDENTIFIER ON
GO
CREATE TABLE [dbo].[StudentTBL](
	[studentID] [int] IDENTITY(1,1) NOT NULL,
	[name] [varchar](150) NOT NULL,
	[displayName] [varchar](150) NOT NULL,
 CONSTRAINT [PK_StudentTBL] PRIMARY KEY CLUSTERED 
(
	[studentID] ASC
)WITH (PAD_INDEX = OFF, STATISTICS_NORECOMPUTE = OFF, IGNORE_DUP_KEY = OFF, ALLOW_ROW_LOCKS = ON, ALLOW_PAGE_LOCKS = ON, OPTIMIZE_FOR_SEQUENTIAL_KEY = OFF) ON [PRIMARY]
) ON [PRIMARY]
GO
INSERT [dbo].[AccountTBL] ([username], [password]) VALUES (N'sonnt', N'12345678')
GO
SET IDENTITY_INSERT [dbo].[StudentTBL] ON 

INSERT [dbo].[StudentTBL] ([studentID], [name], [displayName]) VALUES (1, N'Mr A', N'I am superman')
INSERT [dbo].[StudentTBL] ([studentID], [name], [displayName]) VALUES (2, N'Mr B', N'Database')
INSERT [dbo].[StudentTBL] ([studentID], [name], [displayName]) VALUES (3, N'AAAAAAAA', N'BBBBBBBBBBBBB')
SET IDENTITY_INSERT [dbo].[StudentTBL] OFF
GO
