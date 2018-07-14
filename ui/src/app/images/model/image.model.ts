export class Image {
    public osType: string;
    public osVersion: string;
    public additionalSoftware: string[];

    constructor(osType: string = null, osVersion: string = null, additionalSoftware: string[] = null) {
        this.osType = osType;
        this.osVersion = osVersion;
        this.additionalSoftware = additionalSoftware;
    }

}
