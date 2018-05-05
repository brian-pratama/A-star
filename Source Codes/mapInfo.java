
public class mapInfo {
	//*** heuristic ***
	private double hRavenna = 0.0;
	private double hRimini = 0.5;
	private double hFerrara = 5;
	private double hForli = 2;
	private double hCesena = 4.5;
	private double hFaenza = 4;
	private double hImola = 5;
	private double hEmilia = 6;
	private double hTerme = 7;
	private double hCarpi = 8;
	private double hPiacenza = 10;
	private double hBobbia = 10.5;
	
	//*** distances ***
	private double gRavenna = 0;
	private double gRiminiToRavenna = 1;
	private double gFerraraToImola = 3;
	private double gFerraraToRavenna = 6;
	private double gForliToCesena = 2;
	private double gForliToRavenna = 3;
	private double gCesenaToRimini = 5;
	private double gFaenzaToForli = 2;
	private double gFaenzaToCesena = 6;
	private double gImolaToFaenza = 1;
	private double gImolaToForli = 3;
	private double gEmiliaToImola = 2;
	private double gTermeToEmilia = 2;
	private double gTermeToFaenza = 3;
	private double gCarpiToEmilia = 2;
	private double gCarpiToFerrara = 8;
	private double gPiacenzaToCarpi = 3;
	private double gPiacenzaToTerme = 3;
	private double gBobbiaToPiacenza = 5;
	private double gBobbiaToTerme = 3;
	private double gBobbiaToCesena = 15;
	
	//*** default constructor ***
	public mapInfo(){}
	
	//*** method ***
	
	//*** Set data ***
	public void setHRavenna(double hRavenna){
		this.hRavenna = hRavenna;
	}
	
	public void setHRimini(double hRimini){
		this.hRimini = hRimini;
	}

	public void setHFerrara(double hFerrara){
		this.hFerrara = hFerrara;
	}
	
	public void setHForli(double hForli){
		this.hForli = hForli;
	}

	public void setHCesena(double hCesena){
		this.hCesena = hCesena;
	}

	public void setHFaenza(double hFaenza){
		this.hFaenza = hFaenza;
	}

	public void setHImola(double hImola){
		this.hImola = hImola;
	}

	public void setHEmilia(double hEmilia){
		this.hEmilia = hEmilia;
	}

	public void setHTerme(double hTerme){
		this.hTerme = hTerme;
	}

	public void setHCarpi(double hCarpi){
		this.hCarpi = hCarpi;
	}

	public void setHPiacenza(double hPiacenza){
		this.hPiacenza = hPiacenza;
	}

	public void setHBobbia(double hBobbia){
		this.hBobbia = hBobbia;
	}
	
	public void setGRavenna(double g){
		this.gRavenna = g;
	}
	
	public void setGRiminiToRavenna(double g){
		this.gRiminiToRavenna = g;
	}
	
	public void setGFerraraToImola(double g){
		this.gFerraraToImola = g;
	}
	
	public void setGFerraraToRavenna(double g){
		this.gFerraraToRavenna = g;
	}
	
	public void setGForliToCesena(double g){
		this.gForliToCesena = g;
	}
	
	public void setGForliToRavenna(double g){
		this.gForliToRavenna = g;
	}
	
	public void setGCesenaToRimini(double g){
		this.gCesenaToRimini = g;
	}
	
	public void setGFaenzaToForli(double g){
		this.gFaenzaToForli = g;
	}
	
	public void setGFaenzaToCesena(double g){
		this.gFaenzaToCesena = g;
	}
	
	public void setGImolaToFaenza(double g){
		this.gImolaToFaenza = g;
	}
	
	public void setGImolaToForli(double g){
		this.gImolaToForli = g;
	}
	
	public void setGEmiliaToImola(double g){
		this.gEmiliaToImola = g;
	}
	
	public void setGTermeToEmilia(double g){
		this.gTermeToEmilia = g;
	}
	
	public void setGTermeToFaenza(double g){
		this.gTermeToFaenza = g;
	}
	
	public void setGCarpiToEmilia(double g){
		this.gCarpiToEmilia = g;
	}
	
	public void setGCarpiToFerrara(double g){
		this.gCarpiToFerrara = g;
	}
	
	public void setGPiacenzaToCarpi(double g){
		this.gPiacenzaToCarpi = g;
	}
	
	public void setGPiacenzaToTerme(double g){
		this.gPiacenzaToTerme = g;
	}

	public void setGBobbiaToPiacenza(double g){
		this.gBobbiaToPiacenza = g;
	}
	
	public void setGBobbiaToTerme(double g){
		this.gBobbiaToTerme = g;
	}
	
	public void setGBobbiaToCesena(double g){
		this.gBobbiaToCesena = g;
	}
	
	//*** Get data ***
	public double getHRavenna(){
		return this.hRavenna;
	}
	
	public double getHRimini(){
		return this.hRimini;
	}

	public double getHFerrara(){
		return this.hFerrara;
	}
	
	public double getHForli(){
		return this.hForli;
	}

	public double getHCesena(){
		return this.hCesena;
	}

	public double getHFaenza(){
		return this.hFaenza;
	}

	public double getHImola(){
		return this.hImola;
	}

	public double getHEmilia(){
		return this.hEmilia;
	}

	public double getHTerme(){
		return this.hTerme;
	}

	public double getHCarpi(){
		return this.hCarpi;
	}

	public double getHPiacenza(){
		return this.hPiacenza;
	}

	public double getHBobbia(){
		return this.hBobbia;
	}
	
	public double getGRavenna(){
		return this.gRavenna;
	}
	
	public double getGRiminiToRavenna(){
		return this.gRiminiToRavenna;
	}
	
	public double getGFerraraToImola(){
		return this.gFerraraToImola;
	}
	
	public double getGFerraraToRavenna(){
		return this.gFerraraToRavenna;
	}
	
	public double getGForliToCesena(){
		return this.gForliToCesena;
	}
	
	public double getGForliToRavenna(){
		return this.gForliToRavenna;
	}
	
	public double getGCesenaToRimini(){
		return this.gCesenaToRimini;
	}
	
	public double getGFaenzaToForli(){
		return this.gFaenzaToForli;
	}
	
	public double getGFaenzaToCesena(){
		return this.gFaenzaToCesena;
	}
	
	public double getGImolaToFaenza(){
		return this.gImolaToFaenza;
	}
	
	public double getGImolaToForli(){
		return this.gImolaToForli;
	}
	
	public double getGEmiliaToImola(){
		return this.gEmiliaToImola;
	}
	
	public double getGTermeToEmilia(){
		return this.gTermeToEmilia;
	}
	
	public double getGTermeToFaenza(){
		return this.gTermeToFaenza;
	}
	
	public double getGCarpiToEmilia(){
		return this.gCarpiToEmilia;
	}
	
	public double getGCarpiToFerrara(){
		return this.gCarpiToFerrara;
	}
	
	public double getGPiacenzaToCarpi(){
		return this.gPiacenzaToCarpi;
	}
	
	public double getGPiacenzaToTerme(){
		return this.gPiacenzaToTerme;
	}

	public double getGBobbiaToPiacenza(){
		return this.gBobbiaToPiacenza;
	}
	
	public double getGBobbiaToTerme(){
		return this.gBobbiaToTerme;
	}
	
	public double getGBobbiaToCesena(){
		return this.gBobbiaToCesena;
	}
}
