/*
 * MIT License
 *
 * Copyright (C) 2020 The SimpleCloud authors
 *
 * Permission is hereby granted, free of charge, to any person obtaining a copy of this software and associated
 * documentation files (the "Software"), to deal in the Software without restriction, including without limitation
 * the rights to use, copy, modify, merge, publish, distribute, sublicense, and/or sell copies of the Software,
 * and to permit persons to whom the Software is furnished to do so, subject to the following conditions:
 *
 * The above copyright notice and this permission notice shall be included in all
 * copies or substantial portions of the Software.
 *
 * THE SOFTWARE IS PROVIDED "AS IS", WITHOUT WARRANTY OF ANY KIND, EXPRESS OR IMPLIED,
 * INCLUDING BUT NOT LIMITED TO THE WARRANTIES OF MERCHANTABILITY,
 * FITNESS FOR A PARTICULAR PURPOSE AND NONINFRINGEMENT.
 * IN NO EVENT SHALL THE AUTHORS OR COPYRIGHT HOLDERS BE LIABLE FOR ANY CLAIM,
 * DAMAGES OR OTHER LIABILITY, WHETHER IN AN ACTION OF CONTRACT, TORT OR OTHERWISE,
 * ARISING FROM, OUT OF OR IN CONNECTION WITH THE SOFTWARE OR THE USE OR OTHER
 * DEALINGS IN THE SOFTWARE.
 */

package eu.thesimplecloud.base.manager.network.packets.player

import eu.thesimplecloud.api.CloudAPI
import eu.thesimplecloud.api.exception.NoSuchPlayerException
import eu.thesimplecloud.api.exception.NoSuchServiceException
import eu.thesimplecloud.api.location.SimpleLocation
import eu.thesimplecloud.clientserverapi.lib.connection.IConnection
import eu.thesimplecloud.clientserverapi.lib.packet.packettype.JsonPacket
import eu.thesimplecloud.clientserverapi.lib.promise.ICommunicationPromise
import java.util.*

class PacketInTeleportOtherService : JsonPacket() {

    override suspend fun handle(connection: IConnection): ICommunicationPromise<Any> {
        val playerUniqueId = this.jsonLib.getObject("playerUniqueId", UUID::class.java)
                ?: return contentException("playerUniqueId")
        val serviceName = this.jsonLib.getString("serviceName") ?: return contentException("serviceName")
        val simpleLocation = this.jsonLib.getObject("simpleLocation", SimpleLocation::class.java)
                ?: return contentException("simpleLocation")
        val cloudPlayer = CloudAPI.instance.getCloudPlayerManager().getCachedCloudPlayer(playerUniqueId)
                ?: return failure(NoSuchPlayerException("Player cannot be found"))
        val service = CloudAPI.instance.getCloudServiceManager().getCloudServiceByName(serviceName)
                ?: return failure(NoSuchServiceException("Service cannot be found"))
        if (service.isProxy())
            return failure(IllegalArgumentException("Cannot connect a player to a proxy service."))
        return cloudPlayer.teleport(simpleLocation.toServiceLocation(serviceName))
    }
}