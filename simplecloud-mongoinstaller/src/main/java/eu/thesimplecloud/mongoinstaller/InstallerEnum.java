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

package eu.thesimplecloud.mongoinstaller;


/**
 * Created by IntelliJ IDEA.
 * Date: 07.06.2020
 * Time: 20:57
 *
 * @author Frederick Baier
 */
public enum InstallerEnum {

    DEBIAN_10("echo \"deb http://repo.mongodb.org/apt/debian buster/mongodb-org/4.2 main\" | sudo tee /etc/apt/sources.list.d/mongodb-org-4.2.list"),
    DEBIAN_9("echo \"deb http://repo.mongodb.org/apt/debian stretch/mongodb-org/4.2 main\" | sudo tee /etc/apt/sources.list.d/mongodb-org-4.2.list"),
    UBUNTU_18("echo \"deb [ arch=amd64,arm64 ] https://repo.mongodb.org/apt/ubuntu bionic/mongodb-org/4.2 multiverse\" | sudo tee /etc/apt/sources.list.d/mongodb-org-4.2.list"),
    DEBIAN_16("echo \"deb [ arch=amd64,arm64 ] https://repo.mongodb.org/apt/ubuntu xenial/mongodb-org/4.2 multiverse\" | sudo tee /etc/apt/sources.list.d/mongodb-org-4.2.list");


    private String versionSpecificCommand;

    private InstallerEnum(String versionSpecificCommand) {
        this.versionSpecificCommand = versionSpecificCommand;
    }

    public String getVersionSpecificCommand() {
        return versionSpecificCommand;
    }
}
