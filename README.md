![Banner](https://i.imgur.com/eTQJ1IX.png "Banner")

**Features**

- Multi-Root
- Module-System
- Multi-Proxy
- Template-System
- Language-System
- Powerful API
- Support for Spigot, BungeeCord and Velocity
- MongoDB and SQL support
- Dashboard

**Requirements**

- Java 8
- A working MongoDB or SQL database installation
- 2GB Memory
- 2 virtual cores

**Setup**

- Download the cloud
  from [here](https://www.spigotmc.org/resources/simplecloud-simplify-your-network.79466/download?version=374176 "here")
  .
- Unzip the folder and execute the start file
- Follow the setup instructions
- Connect a wrapper to your manager. It is recommended to use the InternalWrapperModule for this. You can find it below.
- Create your first group by typing create into the console
- For more information type help
- Have fun :)

**Dashbaord**

SimpleCloud provides a Dashboard accessible for every user. The domain for the dashboard
is: http://dashboard-nossl.thesimplecloud.eu. Now you have to enter the IP-Address of your server follwed by the port of
the REST module. The default port of the RESR-Module ist 8585. So an ip would be 55.55.55.55:8585. The username and
passwort can be found in "modules/rest/users.json"

**Modules**

SimpleCloud provides some modules by default.

***Internal-Wrapper Module***

The Internal-Wrapper Module starts a wrapper every time the manager of the cloud gets started. This wrapper does only
run when the manager is running. It connects automatically with no need to set it up. The wrapper will be automatically
named "InternalWrapper" and it will have 2GB of memory. To edit the memory of the wrapper you can use the command:

`edit wrapper InternalWrapper maxMemory <amount in MB>`

***Sign Module***

The Sign Module is used to show available services for players in the lobby via a sign. The players can click on that
sign and will be sent to the server. The layout of the signs is fully customizable.

![SignModule](https://i.imgur.com/w534aZG.gif "SignModule")

***Permission Module***

With the Permission Module, you can easily manage your permissions. You can define groups and add permissions to them.
You can also add permissions to single users

![PermissionModule](https://i.imgur.com/5LXMwCk.jpg "PermissionModule")

***Proxy Module***

The Proxy Module is used to manage your proxies. It controls the MOTD, Tablist, maintenance and the online count. The
online count of proxies of one group will be summed up and displayed in the player info.

![ProxyModuleTab](https://i.imgur.com/2djSS9l.jpg "ProxyModuleTab")

![ProxyModuleMotd](https://i.imgur.com/dkuxYM7.png "ProxyModuleMotd")

![ProxyModuleMotdMaintenance](https://i.imgur.com/eCSXSJo.png "ProxyModuleMotdMaintenance")

Permissions:
Maintenance join: cloud.maintenance.join Full join: cloud.full.join

***Hub Module***

The Hub Module provides a hub command for players to switch to a lobby server.

***Notify Module***

The notify module sends notifications to players that have the required permission when a server gets started or
stopped.

![NotifyModule](https://i.imgur.com/7lcjXbN.jpg "NotifyModule")

Permission: cloud.module.notify.messages

***REST Module***

The REST Module provides a restful API. It is necessary for the dashboard.

***Statistics Module***

The Statistics Module saves some statistics of the cloud. The data is displayed on the dashboard.

***Chat + Tab Module***

The Chat + Tab Module provides prefixes and suffixes in the tablist and adds a chat configuration.

If you have any question you can contact us via [discord](https://discord.gg/MPZs4h8 "discord").
