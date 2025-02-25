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

package eu.thesimplecloud.base.manager.commands

import eu.thesimplecloud.api.command.ICommandSender
import eu.thesimplecloud.api.service.ICloudService
import eu.thesimplecloud.launcher.console.command.CommandType
import eu.thesimplecloud.launcher.console.command.ICommandHandler
import eu.thesimplecloud.launcher.console.command.annotations.Command
import eu.thesimplecloud.launcher.console.command.annotations.CommandArgument
import eu.thesimplecloud.launcher.console.command.annotations.CommandSubPath
import eu.thesimplecloud.launcher.console.command.provider.ServiceCommandSuggestionProvider

/**
 * Created by IntelliJ IDEA.
 * Date: 09.06.2020
 * Time: 16:54
 * @author Frederick Baier
 */
@Command("copy", CommandType.CONSOLE_AND_INGAME, "cloud.command.copy")
class CopyCommand : ICommandHandler {

    @CommandSubPath("<service> <path>", "Copies the specified directory to the template folder")
    fun handle(
            commandSender: ICommandSender,
            @CommandArgument("service", ServiceCommandSuggestionProvider::class) service: ICloudService,
            @CommandArgument("path") path: String
    ) {
        if (!service.isActive()) {
            commandSender.sendProperty("manager.command.copy.service-inactive")
            return
        }
        commandSender.sendProperty("manager.command.copy.start", service.getName())
        service.copy(path)
                .addResultListener {
                    commandSender.sendProperty("manager.command.copy.success")
                }.addFailureListener {
                    val messageCause = it.message ?: it::class.java.simpleName
                    commandSender.sendProperty("manager.command.copy.failed", messageCause)
                }
    }

}